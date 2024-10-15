package apartado3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class CargarLibros {
    private String directorio; // Ruta del directorio de los archivos XML

    // Constructor que recibe la ruta del directorio
    public CargarLibros(String directorio) {
        this.directorio = directorio; // Inicializa la ruta del directorio
    }

    // Método para cargar los libros desde los archivos XML
    public List<Libro> cargar() {
        List<Libro> librosCargados = new ArrayList<>();

        // Cargar archivos desde el directorio
        File carpeta = new File(directorio);
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("El directorio especificado no existe o no es válido.");
            return librosCargados; // Retornar lista vacía
        }

        XStream xstream = new XStream(new DomDriver());
        // Definir alias para la clase Libro
        xstream.alias("libro", apartado3.Libro.class);

        // Cargar los libros almacenados en archivos XML
        File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".xml")); // Filtrar archivos XML
        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron libros en el directorio.");
            return librosCargados; // Retornar lista vacía
        }

        // Restaurar y agregar los libros a la lista
        for (File archivo : archivos) {
            try {
                Libro libro = (Libro) xstream.fromXML(archivo); // Leer y convertir el XML a Libro
                librosCargados.add(libro); // Añadir a la lista
            } catch (Exception e) {
                System.out.println("Error al cargar el libro desde el archivo: " + archivo.getName());
                e.printStackTrace();
            }
        }

        return librosCargados; // Retornar la lista de libros cargados
    }
}