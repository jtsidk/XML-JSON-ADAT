package practica2;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecuperarLibro {
    private static String archivoRecuperar;
    private static XStream xstream1;

    public RecuperarLibro(String archivoRecuperar) {
        RecuperarLibro.archivoRecuperar = archivoRecuperar;
        RecuperarLibro.xstream1 = new XStream(new DomDriver());
        xstream1.addPermission(AnyTypePermission.ANY);
        
        // Apartado 2
     // Definir alias para la clase Libro
        xstream1.alias("libro", Libro.class);
    }

    public static Libro leer() {
        String datosLeidoString = "";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(archivoRecuperar));
            String linea;
            while ((linea = in.readLine()) != null) {
                datosLeidoString += linea;  // Concatenar las líneas
            }
            System.out.println("Datos leídos: " + datosLeidoString);  // Para depuración

            // Deserializar el XML a un objeto Libro
            return (Libro) xstream1.fromXML(datosLeidoString);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();  // Cerrar el BufferedReader
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;  // Retornar null si hay un error
    }
}
