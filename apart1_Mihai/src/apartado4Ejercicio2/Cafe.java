package apartado4Ejercicio2;

/**
 * @descrition Clase para representar objetos Cafe del modelo
 * @author Laura
 * @date 27/4/2015
 * @version 1.0
 * @license GPLv3
 */

public class Cafe {
    private String nombre;
    private int proveedorId; // Este campo será omitido en el XML
    private float precio;
    private int ventas;
    private int total;

    // Constructor con argumentos
    public Cafe(String nombre, int proveedorId, float precio, int ventas, int total) {
        this.nombre = nombre;
        this.proveedorId = proveedorId;
        this.precio = precio;
        this.ventas = ventas;
        this.total = total;
    }

    // Constructor sin argumentos
    public Cafe() {
        // Este constructor es necesario para la deserialización
    }

    public String getNombre() {
        return nombre;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public float getPrecio() {
        return precio;
    }

    public int getVentas() {
        return ventas;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", ventas=" + ventas +
                ", total=" + total +
                '}';
    }
}