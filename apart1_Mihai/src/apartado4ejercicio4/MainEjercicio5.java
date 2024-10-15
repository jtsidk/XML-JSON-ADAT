package apartado4ejercicio4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class MainEjercicio5 {
	public static void main(String[] args) {
        // Configurar XStream
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
        String xmlFilePath = "Persona.xml";

        // Guardar el objeto Persona a un archivo XML
        try (FileWriter writer = new FileWriter(xmlFilePath)) {
            xstream.toXML(persona, writer);
            System.out.println("Objeto Persona guardado en el archivo: " + xmlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer el objeto Persona desde el archivo XML
        try (FileReader reader = new FileReader(xmlFilePath)) {
            Persona personaCargada = (Persona) xstream.fromXML(reader);
            System.out.println("Persona cargada desde el archivo XML:");
            System.out.println(personaCargada);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
