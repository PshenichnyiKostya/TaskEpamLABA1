package main.java.parser;

import main.java.bean.Client;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import java.util.List;

public class DOMClientParser implements XMLParser<Client> {

    private static DOMClientParser ourInstance;
    private DocumentBuilder documentBuilder;

    static {
        ourInstance = new DOMClientParser();
    }

    public static DOMClientParser getInstance() {
        return ourInstance;
    }
    @Override
    public List<Client> getData(String path) throws ParserException {
        return null;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
