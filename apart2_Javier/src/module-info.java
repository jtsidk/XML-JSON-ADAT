module reto2 {
	requires xstream;
	requires com.google.gson;
	requires org.json;
	
	opens reto2apart2 to xstream, com.google.gson;
	exports reto2apart2;
}