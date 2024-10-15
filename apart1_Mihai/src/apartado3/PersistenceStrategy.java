package apartado3;

import java.io.File;
import java.util.List;

import practica2.Libro;

public interface PersistenceStrategy {
    void guardar(List<Libro> libros);
    List<Libro> cargar();
    File getArchivo(); // Añade este método
}
