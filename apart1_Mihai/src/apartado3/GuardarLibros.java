package apartado3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GuardarLibros {
    private apartado3.Libro[] libros; // Array de libros

    // Constructor que recibe un array de libros
    public GuardarLibros(apartado3.Libro[] libros2) {
        this.libros = libros2; // Inicializa el array de libros
    }

    // Método para guardar los libros
    public void guardar() {
        // Especificar el nombre del directorio existente
        File carpeta = new File("C:\\Users\\Miha\\Videos\\Captures\\Libros");

        if (!carpeta.exists()) {
            carpeta.mkdirs(); // Crear el directorio si no existe
        }

        XStream xstream = new XStream(new DomDriver());
        // Definir alias para la clase Libro
        xstream.alias("libro", apartado3.Libro.class);

        // Guardar cada libro uno por uno
        for (apartado3.Libro libro : libros) {
            String xml = xstream.toXML(libro); // Convertir el libro a XML
            try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File(carpeta, libro.getTitulo() + ".xml")))) {
                out.write(xml);  // Escribir el XML en el archivo
                System.out.println("Libro guardado: " + libro.getTitulo()); // Imprimir cada libro guardado
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al guardar el libro: " + libro.getTitulo());
            }
        }

        // Mensaje para indicar que los libros se han guardado correctamente
        System.out.println("Todos los libros han sido guardados en el directorio: " + carpeta.getAbsolutePath());
    }
}