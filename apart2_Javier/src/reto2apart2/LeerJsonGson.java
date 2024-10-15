package reto2apart2;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LeerJsonGson {

	public static void main (String[] args) {
		System.out.println("Iniciando programa");
		Gson gson = new Gson();
		
		try (BufferedReader br = new BufferedReader(new FileReader("producto.json"))) {
			JsonObject productojson  = gson.fromJson(br, JsonObject.class);
			String respuesta = productojson.get("producto").toString();
			System.out.println(respuesta);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}


/*
try (FileReader fr = new FileReader("producto.json")) {
	Producto producto = gson.fromJson(fr, Producto.class);
	System.out.println("Objeto producto regenerado con GSON");
	System.out.println("ID: " + producto.getId());
	System.out.println("Descripcion: " + producto.getDescripcion());
	System.out.println("Precio: " + producto.getPrecio());
}catch (IOException e) {
	e.printStackTrace();
}
*/