package parser;

import bean.Client;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DOMClientParser implements XMLParser<Client> {

    private static DOMClientParser ourInstance;
    private DocumentBuilder documentBuilder;

    static {
        try {
            ourInstance = new DOMClientParser();
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
    private DOMClientParser() throws ParserException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException("Error in initialize DOM Parser" + e);
        }
    }



    public static DOMClientParser getInstance() {
        return ourInstance;
    }

    @Override
    public List<Client> getData(String path) throws ParserException {
        List<Client> cards = new ArrayList<>();
        Document document;
        try {
            Path path1 = Paths.get(DOMClientParser.class.getResource(path).toURI()).toAbsolutePath();
            document = documentBuilder.parse(path1.toString());
            Element element = document.getDocumentElement();
            NodeList cardList = element.getElementsByTagName("client");
            for (int i = 0; i < cardList.getLength(); i++) {
                Element cardElement = (Element) cardList.item(i);
                Client client = buildClient(cardElement);
                cards.add(client);
            }
        } catch (URISyntaxException e) {
            throw new ParserException("Wrong filepath");
        } catch (SAXException | IOException e) {
            throw new ParserException(e);
        }
        return cards;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private Client buildClient(Element element) {
        Client client = new Client();
        client.setId(getElementTextContent(element, "id"));
        client.setFreeMiles(Double.parseDouble(getElementTextContent(element, "free-miles")));
        client.setLogin(getElementTextContent(element, "login"));
        client.setPass(getElementTextContent(element, "pass"));
        client.setName(getElementTextContent(element, "name"));
        client.setSurname(getElementTextContent(element, "surname"));
        client.setDiscount(Integer.parseInt(getElementTextContent(element, "discount")));
        return client;
    }
}
