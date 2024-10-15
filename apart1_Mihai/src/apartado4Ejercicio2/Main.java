package apartado4Ejercicio2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configuración de XStream
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("cafe", Cafe.class);
        xStream.omitField(Cafe.class, "proveedorId");
        xStream.addPermission(AnyTypePermission.ANY);

        // Crear y guardar objetos Cafe
        List<Cafe> cafes = new ArrayList<>();
        cafes.add(new Cafe("Café Espresso", 1, 2.5f, 10, 25));
        cafes.add(new Cafe("Café Americano", 2, 3.0f, 5, 15));

        // Persistir objetos Cafe
        FilePersistenceStrategy persistence = new FilePersistenceStrategy("cafe.xml", xStream);
        persistence.guardar(cafes);
        System.out.println("Datos guardados en cafe.xml");

        // Cargar objetos Cafe
        List<Cafe> loadedCafes = (List<Cafe>) persistence.cargar();
        System.out.println("Cafés cargados desde el archivo:");
        for (Cafe cafe : loadedCafes) {
            System.out.println(cafe);
        }
    }
}
