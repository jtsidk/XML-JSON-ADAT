/**
 *Aula.java
 *@author Laura Lozano
 *@version 1.0
 */

package apartado4Ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 *  @descrition Clase que describe un Aula de Alumnos para los ejercicios
 *	@author Laura
 *  @date 26/3/2015
 *  @version 1.0
 *  @license GPLv3
 */
public class Aula {
    private List<Alumno> alumnos;

    // Constructor sin argumentos (no-args constructor)
    public Aula() {
        alumnos = new ArrayList<Alumno>();
    }

    // Constructor que permite especificar un tamaño inicial
    public Aula(int tamano) {
        alumnos = new ArrayList<Alumno>(tamano);
    }

    public void add(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void informacionAlumnos() {
        System.out.println("El aula tiene los siguientes alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
    }
}
