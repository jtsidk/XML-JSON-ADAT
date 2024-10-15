package Reto2;

import java.util.List;

public class Libro {
    private String titulo;
    private String autor;
    private List<Capitulo> capitulos;

    // Constructor, Getters y Setters

    public Libro(String titulo, String autor, List<Capitulo> capitulos) {
        this.titulo = titulo;
        this.autor = autor;
        this.capitulos = capitulos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", capitulos=" + capitulos +
                '}';
    }
}