package apartado3;

public class Libro {
    public int isbn;       // Cambiado a público
    public String titulo;  // Cambiado a público
    public String editorial; 
    public int paginas; 
    public String autor; 
    public int copias; 

    public Libro(int isbn, String titulo, String editorial, int paginas, String autor, int copias) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.paginas = paginas;
        this.autor = autor;
        this.copias = copias;
    }

    public String getTitulo() {
        return titulo;
    }

    // Método toString para imprimir los detalles del libro
    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", copias=" + copias +
                '}';
    }
}
