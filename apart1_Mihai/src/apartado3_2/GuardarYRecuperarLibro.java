package apartado3_2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GuardarYRecuperarLibro {
    private static final String RUTA_DOCUMENTOS = System.getProperty("user.home") + "\\Documentos\\libro.xml"; // Usar "\\" para evitar problemas de escape en Windows

    public static void guardarLibro(Libro libro) {
        XStream xstream = new XStream(new DomDriver());
        
        // Definir alias para la clase Libro
        xstream.alias("libro", Libro.class);
        
        // Permitir la clase Libro para la serialización/deserialización
        xstream.allowTypes(new Class[]{Libro.class});
        
        // Asegurarse de que el directorio existe
        Path path = Paths.get(System.getProperty("user.home"), "Documentos");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path); // Crear el directorio si no existe
                System.out.println("El directorio fue creado: " + path);
            } catch (IOException e) {
                System.out.println("Error al crear el directorio: " + e.getMessage());
                return; // No continuar si no se puede crear el directorio
            }
        }

        String xml = xstream.toXML(libro); // Convertir el objeto Libro a XML
        try (FileOutputStream fos = new FileOutputStream(RUTA_DOCUMENTOS)) {
            fos.write(xml.getBytes()); // Escribir el XML en el archivo
            System.out.println("Libro guardado en: " + RUTA_DOCUMENTOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Libro recuperarLibro() {
        XStream xstream = new XStream(new DomDriver());
        
        // Definir alias para la clase Libro
        xstream.alias("libro", Libro.class);
        
        // Permitir la clase Libro para la serialización/deserialización
        xstream.allowTypes(new Class[]{Libro.class});

        try (FileInputStream fis = new FileInputStream(RUTA_DOCUMENTOS)) {
            return (Libro) xstream.fromXML(fis); // Leer desde XML y convertir a objeto
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.out.println("Error al convertir el objeto: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        // Crear un libro
        Libro libro = new Libro(123456, "El Quijote", "Editorial Uno", 500, "Cervantes", 3);
        
        // Guardar el libro
        guardarLibro(libro);
        
        // Recuperar el libro
        Libro libroRecuperado = recuperarLibro();
        if (libroRecuperado != null) {
            System.out.println("Libro recuperado: " + libroRecuperado);
        } else {
            System.out.println("No se pudo recuperar el libro.");
        }
    }
}

