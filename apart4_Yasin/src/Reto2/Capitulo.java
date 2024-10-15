package Reto2;


class Capitulo {
    private int numero;
    private String titulo;

    // Constructor, Getters y Setters

    public Capitulo(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Capitulo{" +
                "numero=" + numero +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}