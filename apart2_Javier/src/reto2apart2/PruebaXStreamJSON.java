package reto2apart2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import java.io.*;

public class PruebaXStreamJSON {
	
	public static void main(String[] args) {
		//Creamos un objeto de la clase persona
		Producto producto = new Producto(12, "Banana", new Float(23.00));
		
		//Usamos XStream con JSONHierarchicalStreamDriver
		XStream xstream = new XStream (new JsonHierarchicalStreamDriver());
		xstream.alias("producto", Producto.class);
		
		//Convertimos en objeto JSON
		String json = xstream.toXML(producto);
		
		//guardamos en un fichero de texto plano el json
		try (FileWriter fichero = new FileWriter("producto.json")) {
			fichero.write(json);
			System.out.println("JSON generado y guardado en persona.json");
			System.out.println(json);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
