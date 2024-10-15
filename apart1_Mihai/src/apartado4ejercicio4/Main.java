package apartado4ejercicio4;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Configuración de XStream
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("persona", Persona.class);
        xstream.alias("telefono", Telefono.class);
        xstream.aliasField("prefijo", Telefono.class, "codigo"); // Alias para el campo codigo
        xstream.addPermission(AnyTypePermission.ANY);  // Permitir la serialización de cualquier clase

        // Crear un objeto Persona con su Telefono
        Telefono telefono = new Telefono();
        telefono.setCodigo(34);
        telefono.setNumero(123456789);
        
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Pérez");
        persona.setTelefono(telefono);

        // Ruta del archivo XML
        String xmlFilePath = "persona.xml";

        // Convertir objeto Persona a XML y guardar en un archivo
        String xml = xstream.toXML(persona);
        try (FileWriter writer = new FileWriter(xmlFilePath)) {
            writer.write(xml);
            System.out.println("Datos de la persona guardados en: " + xmlFilePath);
            System.out.println("XML generado:");
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recuperar el objeto Persona desde el archivo XML
        try (FileReader reader = new FileReader(xmlFilePath)) {
            Persona personaCargada = (Persona) xstream.fromXML(reader);
            System.out.println("Persona cargada desde el archivo:");
            System.out.println(personaCargada);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
