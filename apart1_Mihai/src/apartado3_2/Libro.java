package apartado3_2;

public class Libro {
    private int isbn;
    private String titulo;
    private String editorial;
    private int paginas;
    private String autor;
    private int copias;

    // Constructor por defecto (sin argumentos)
    public Libro() {
        // Puedes inicializar los valores por defecto si lo deseas
    }

    // Constructor completo
    public Libro(int isbn, String titulo, String editorial, int paginas, String autor, int copias) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.paginas = paginas;
        this.autor = autor;
        this.copias = copias;
    }

    // Getters y Setters
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

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
