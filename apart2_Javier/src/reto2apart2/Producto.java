package reto2apart2;

public class Producto {

	public int id;
	public String descripcion;
	public float precio;

	public Producto(int id, String descripcion, float precio) {
		this.id=id;
		this.descripcion=descripcion;
		this.precio=precio;
	}

	public Producto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String toString() {
		return "Id: "+ id + "\nDescripcion: " + descripcion + "\nPrecio: " + precio;
	}

}
