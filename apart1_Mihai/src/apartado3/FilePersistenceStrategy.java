package apartado3;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.security.WildcardTypePermission;

import practica2.Libro;

public class FilePersistenceStrategy implements PersistenceStrategy {
    private File archivo;

    public FilePersistenceStrategy(File archivo) {
        this.archivo = archivo;
    }

    public void guardar(List<Libro> libros) {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("libro", Libro.class);
        xstream.addPermission(new WildcardTypePermission(new String[]{"practica2.Libro"}));

        try (FileWriter escritor = new FileWriter(archivo)) {
            xstream.toXML(libros, escritor);
            System.out.println("Libros guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los libros: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Libro> cargar() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("libro", Libro.class);
        xstream.addPermission(new WildcardTypePermission(new String[]{"practica2.Libro"}));

        List<Libro> listaLibros = new ArrayList<>();
        try (FileReader lector = new FileReader(archivo)) {
            listaLibros = (List<Libro>) xstream.fromXML(lector);
            System.out.println("Libros cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar los libros: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.out.println("Error al convertir los datos a la lista de libros.");
            e.printStackTrace();
        }
        return listaLibros;
    }

    public File getArchivo() { // Implementación del método
        return archivo;
    }

	@Override
	public Object get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
