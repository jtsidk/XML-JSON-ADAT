package apartado4Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;

public class Main {
    public static void main(String[] args) {
        // Crear una lista para los objetos Cafe
        List<Cafe> cafes = new ArrayList<>();
        cafes.add(new Cafe("Café Espresso", 1, 2.5f, 10, 25));
        cafes.add(new Cafe("Café Americano", 2, 3.0f, 5, 15));

        // Configurar XStream
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("cafe", Cafe.class);
        xstream.omitField(Cafe.class, "proveedorId"); // Omitir el campo proveedorId
        xstream.addPermission(AnyTypePermission.ANY); // Permitir cualquier tipo para la conversión

        // Ruta del archivo XML
        String xmlFilePath = "C:\\Users\\Miha\\Videos\\Captures\\cafe.xml";

        // Convertir la lista de Cafes a XML y guardar
        String xml = xstream.toXML(cafes); // Convierte la lista a XML
        try (FileWriter writer = new FileWriter(xmlFilePath)) {
            writer.write(xml);
            System.out.println("Datos guardados en: " + xmlFilePath);
            System.out.println("XML generado:");
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cargar objetos Cafe desde XML
        try (FileReader reader = new FileReader(xmlFilePath)) {
            @SuppressWarnings("unchecked")
            List<Cafe> loadedCafes = (List<Cafe>) xstream.fromXML(reader);
            System.out.println("Cafés cargados desde el XML:");
            for (Cafe cafe : loadedCafes) {
                System.out.println(cafe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}