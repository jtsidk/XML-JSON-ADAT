package apartado4Ejercicio7;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
public class MainEjercicio8 {
	public static void main(String[] args) {
        // Configurar XStream
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("aula", Aula.class); // Cambiar el alias a "aula"
        xstream.alias("alumno", Alumno.class); // Cambiar el alias a "alumno"
        xstream.addPermission(AnyTypePermission.ANY); // Permitir la serialización de cualquier clase

        // Crear el objeto Aula
        Aula aula = new Aula(3); // Definimos un tamaño de 3 para el aula

        // Crear objetos Alumno con datos fijos
        Alumno alumno1 = new Alumno("Juan", "Pérez", "01/01/2000", "Avenida Libertador", 123);
        Alumno alumno2 = new Alumno("María", "González", "15/05/1998", "Calle Mayor", 456);
        Alumno alumno3 = new Alumno("Carlos", "Fernández", "22/03/1999", "Calle del Sol", 789);

        // Añadir alumnos al aula
        aula.add(alumno1);
        aula.add(alumno2);
        aula.add(alumno3);

        // Ruta del archivo XML en el directorio Documentos del usuario
        String xmlFilePath = Paths.get(System.getProperty("user.home"), "Documentos", "Aula.xml").toString();

        // Persistir el objeto Aula a un archivo XML
        try (FileWriter writer = new FileWriter(xmlFilePath)) {
            xstream.toXML(aula, writer);
            System.out.println("Objeto Aula guardado en el archivo: " + xmlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Restaurar el objeto Aula desde el archivo XML
        try (FileReader reader = new FileReader(xmlFilePath)) {
            Aula aulaCargada = (Aula) xstream.fromXML(reader);
            System.out.println("Aula cargada desde el archivo XML:");
            aulaCargada.informacionAlumnos(); // Mostrar información de los alumnos
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
