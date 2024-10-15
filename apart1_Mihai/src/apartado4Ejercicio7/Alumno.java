/**
 *Alumno.java
 *@author Laura Lozano
 *@version 1.0
 */
package apartado4Ejercicio7;

/**
 *  @descrition Clase que describe un Alumno para los ejercicios
 *	@author Laura
 *  @date 26/3/2015
 *  @version 1.0
 *  @license GPLv3
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private String fecha; // Cambiado a String para representar la fecha
    private String calle; // Atributo para la calle
    private int numero; // Atributo para el número

    // Constructor sin argumentos
    public Alumno() {
        // Constructor vacío
    }

    public Alumno(String nombre, String apellidos, String fecha, String calle, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha = fecha; // Aquí se almacena la fecha
        this.calle = calle; // Calle del alumno
        this.numero = numero; // Número de la calle
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFecha() {
        return fecha; // Método getter para la fecha
    }

    public String getCalle() {
        return calle; // Método getter para la calle
    }

    public int getNumero() {
        return numero; // Método getter para el número
    }

    @Override
    public String toString() {
        return "El alumno se llama: " + nombre + " " + apellidos + 
               "\tFecha: " + fecha + 
               "\tVive en: " + calle + ", Número: " + numero;
    }
}
	

	

