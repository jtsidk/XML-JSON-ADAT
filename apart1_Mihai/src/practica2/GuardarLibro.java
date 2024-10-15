package practica2;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GuardarLibro {
    private String archivo;
    private XStream xstream1;

    public GuardarLibro(String archivo) {
        this.archivo = archivo;
        this.xstream1 = new XStream(new DomDriver());
        xstream1.addPermission(AnyTypePermission.ANY);  // Permitir todas las clases para la serialización
        
        
        //Apartado2
     // Definir alias para la clase Libro
        xstream1.alias("libro", Libro.class);
    }

    public void guardar(Object libro) {
        String datosGuardar = xstream1.toXML(libro);  // Convertir el objeto en XML
        try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(archivo))) {
            out.write(datosGuardar);  // Escribir el XML en el archivo
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");// Imprimir el error si ocurre
        }
    }
}
