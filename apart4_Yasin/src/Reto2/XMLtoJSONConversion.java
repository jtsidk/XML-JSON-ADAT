package Reto2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class XMLtoJSONConversion {
    public static void main(String[] args) {
    	
    	
        //iniciamos xstream
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("libro", Libro.class);
        xstream.alias("capitulo", Capitulo.class);

        // leer el XML desde el archivo y deserializarlo
        try {
            FileReader fileReader = new FileReader("dataset.xml");
            List<Libro> libros = (List<Libro>) xstream.fromXML(fileReader);
            System.out.println("Objetos deserializados desde XML: " + libros);

            
            // Convertir la lista de libros a JSON usando GSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(libros);

            // guardar el json en un archivo
            try (FileWriter jsonWriter = new FileWriter("libros.json")) {
                jsonWriter.write(json);
                System.out.println("JSON guardado en 'libros.json'.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
