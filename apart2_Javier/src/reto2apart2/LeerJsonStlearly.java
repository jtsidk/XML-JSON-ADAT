package reto2apart2;

import org.json.JSONObject;
import java.io.*;

public class LeerJsonStlearly {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new FileReader("producto.json"))){
			String line;
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			JSONObject objJson = new JSONObject(sb.toString());
			JSONObject producto = objJson.getJSONObject("producto");
			
			int id = producto.getInt("id");
			String descripcion = producto.getString("descripcion");
			float precio = producto.getFloat("precio");
			
			System.out.println("ID: " + id);
			System.out.println("Descripcion: " + descripcion);
			System.out.println("Precio: " + precio);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
