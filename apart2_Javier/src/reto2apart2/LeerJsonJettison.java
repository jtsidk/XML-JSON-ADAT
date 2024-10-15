package reto2apart2;

import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.io.*;

public class LeerJsonJettison {

	public static void main(String[] args) {
		
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("producto", Producto.class);
		
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(new Class[] {
			Producto.class
		});
		
		try(FileReader fr = new FileReader("producto.json")) {
			Producto producto = (Producto) xstream.fromXML(fr);
			System.out.println("Objeto producto regenerado con JettisonMappedXmlDriver ");
			System.out.println("Id: " + producto.getId());
			System.out.println("Descripcion: " + producto.getDescripcion());
			System.out.println("Precio: " + producto.getPrecio());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
