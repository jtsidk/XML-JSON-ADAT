package apartado3;

import java.io.File;
import java.util.List;


public class MainApartado3 {
    public static void main(String[] args) {
        // Crear algunos libros de ejemplo
        Libro libro1 = new Libro(123456, "El Quijote", "Editorial Uno", 500, "Cervantes", 3);
        Libro libro2 = new Libro(789012, "1984", "Editorial Dos", 328, "Orwell", 2);

        // Crear un array de libros
        Libro[] libros = {libro1, libro2};

        // Guardar los libros
        GuardarLibros guardarLibros = new GuardarLibros(libros);
        guardarLibros.guardar();

        // Especificar el directorio donde están los archivos XML de libros
        String rutaDirectorio = "C:\\Users\\Miha\\Videos\\Captures\\Libros";
        File dir = new File(rutaDirectorio);

        // Verificar si el directorio existe y contiene archivos
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Archivos en el directorio antes de cargar:");
            for (String archivo : dir.list()) {
                System.out.println(archivo);  // Muestra los archivos en el directorio
            }
        } else {
            System.out.println("El directorio no existe o no es válido.");
        }

        // Cargar los libros guardados en el directorio
        CargarLibros cargarLibros = new CargarLibros(rutaDirectorio);
        List<Libro> librosCargados = cargarLibros.cargar();

        // Imprimir los libros cargados en el main
        System.out.println("Libros cargados desde el directorio: " + rutaDirectorio);
        if (librosCargados.isEmpty()) {
            System.out.println("No se encontraron libros en el directorio.");
        } else {
            for (Libro libro : librosCargados) {
                System.out.println(libro); // Imprimir cada libro
            }
        }
    }
}
