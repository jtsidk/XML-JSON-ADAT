package apartado4Ejercicio2;

import com.thoughtworks.xstream.XStream;
import java.io.*;

public class FilePersistenceStrategy {
    private final String filePath;
    private final XStream xStream;

    public FilePersistenceStrategy(String filePath, XStream xStream) {
        this.filePath = filePath;
        this.xStream = xStream;
    }

    public void guardar(Object data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(xStream.toXML(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object cargar() {
        try (FileReader reader = new FileReader(filePath)) {
            return xStream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
