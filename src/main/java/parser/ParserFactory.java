package parser;

public class ParserFactory {
    private static ParserFactory ourInstance = new ParserFactory();

    public static ParserFactory getInstance() {
        return ourInstance;
    }

    private final XMLParser domClientParser = DOMClientParser.getInstance();

    public XMLParser getDomClientParser() {
        return domClientParser;
    }

    private ParserFactory() {
    }
}
