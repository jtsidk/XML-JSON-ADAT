package apartado4ejercicio6;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import practica2.Libro;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Configurar XStream
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("ejemplar", Libro.class); // Cambiar el alias de "Libro" a "ejemplar"
        xstream.addPermission(AnyTypePermission.ANY); // Permitir la serialización de cualquier clase

        // Crear un objeto Libro
        Libro libro = new Libro(9, "Cien años de soledad", "Editorial Sudamericana", 400, "Gabriel García Márquez", 3);

        // Ruta del archivo XML en el directorio Documentos del usuario
        String xmlFilePath = Paths.get(System.getProperty("user.home"), "Documents", "Libro.xml").toString();

        // Persistir el objeto Libro a un archivo XML
        try (FileWriter writer = new FileWriter(xmlFilePath)) {
            xstream.toXML(libro, writer);
            System.out.println("Objeto Libro guardado en el archivo: " + xmlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Restaurar el objeto Libro desde el archivo XML
        try (FileReader reader = new FileReader(xmlFilePath)) {
            Libro libroCargado = (Libro) xstream.fromXML(reader);
            System.out.println("Libro cargado desde el archivo XML:");
            System.out.println(libroCargado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
