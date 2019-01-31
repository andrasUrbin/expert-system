import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import java.util.logging.Level;

public abstract class XMLParser {

    protected Document document;
    private Logger logger = Logger.getLogger(XMLParser.class.getName());

    public void loadXmlDocument(String xmlPath) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputStream is = new FileInputStream(xmlPath);
            this.document = db.parse(is);
            this.document.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            logger.log(Level.WARNING, e.getLocalizedMessage());
            System.exit(1);
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getLocalizedMessage());
            System.exit(1);
        } catch (SAXException e) {
            logger.log(Level.WARNING, e.getLocalizedMessage());
            System.exit(1);
        }
    }

    public Document getDocument() {
        return document;
    }
}
