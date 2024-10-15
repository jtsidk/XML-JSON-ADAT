package apartado3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class main {

	public static void main(String[] args) {
		File file = new File("datoslibro.xml");
		try {
	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			 
			Element raiz = doc.getDocumentElement();
	         System.out.println("Elemento raíz: " + raiz.getNodeName());
	          
	          NodeList listaLibros = doc.getElementsByTagName("XSTREAM.Libro");
	          for(int i = 0; i< listaLibros.getLength(); i++) {
	        	  Node libro = listaLibros.item(i);
	        	  
	        	  if(libro.getNodeType() == Node.ELEMENT_NODE) {
	        		  Element elementol = (Element) libro;
	        		  String isbn = elementol.getElementsByTagName("isbn").item(0).getTextContent();
	        		  String titulo = elementol.getElementsByTagName("titulo").item(0).getTextContent();
	        		  String editorial = elementol.getElementsByTagName("editorial").item(0).getTextContent();
	        		  String paginas = elementol.getElementsByTagName("paginas").item(0).getTextContent();
	        		  String autor = elementol.getElementsByTagName("autor").item(0).getTextContent();
	        		  String copias = elementol.getElementsByTagName("copias").item(0).getTextContent();
	        		  
	        		  System.out.println("Libro");
	        		  System.out.println("ISBN--->"+isbn);
	        		  System.out.println("Editorial--->"+editorial);
	        		  System.out.println("Paginas--->"+paginas);
	        		  System.out.println("autor--->"+autor);
	        		  System.out.println("copias--->"+copias);
	        	  }
	          }
			}
			catch(Exception e) {
			e.printStackTrace();
			}
		
	}

}
