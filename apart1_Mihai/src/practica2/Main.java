package practica2;

public class Main {
public static void main(String[] args ) {

	Libro libro1 = new Libro(4,"Prueba","YO",300,"YOX2",40);
	GuardarLibro guardarLibro = new GuardarLibro("C:\\Users\\Miha\\Videos/pruebaApartado1.txt");
	guardarLibro.guardar(libro1);
	
	
	Libro libro2 = new Libro();
	RecuperarLibro recuperar = new RecuperarLibro("C:\\\\Users\\\\Miha\\\\Videos/pruebaApartado1.txt");
	System.out.println(libro2.toString());
	libro2 = RecuperarLibro.leer();	
		System.out.println(libro2.toString());
		
		
		
	
	
	
	
}
}
