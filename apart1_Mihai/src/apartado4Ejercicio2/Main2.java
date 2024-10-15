package apartado4Ejercicio2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        // Configuración de XStream
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("cafe", Cafe.class);
        xStream.omitField(Cafe.class, "proveedorId");
        xStream.addPermission(AnyTypePermission.ANY);

        // Crear objetos Cafe
        List<Cafe> cafes = new ArrayList<>();
        cafes.add(new Cafe("Café Espresso", 1, 2.5f, 10, 25));
        cafes.add(new Cafe("Café Americano", 2, 3.0f, 5, 15));

        // Guardar objetos Cafe a un archivo usando toXML
        try (OutputStream outputStream = new FileOutputStream("cafe2.xml")) {
            xStream.toXML(cafes, outputStream);
            System.out.println("Datos guardados en cafe2.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cargar objetos Cafe desde el archivo usando fromXML
        try (InputStream inputStream = new FileInputStream("cafe2.xml")) {
            @SuppressWarnings("unchecked")
            List<Cafe> loadedCafes = (List<Cafe>) xStream.fromXML(inputStream);
            System.out.println("Cafés cargados desde el archivo:");
            for (Cafe cafe : loadedCafes) {
                System.out.println(cafe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
