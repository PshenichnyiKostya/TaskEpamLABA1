package parser;

/**
 * The type Parser factory.
 */
public class ParserFactory {
    private static ParserFactory ourInstance = new ParserFactory();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ParserFactory getInstance() {
        return ourInstance;
    }

    private final XMLParser domClientParser = DOMClientParser.getInstance();

    /**
     * Gets dom client parser.
     *
     * @return the dom client parser
     */
    public XMLParser getDomClientParser() {
        return domClientParser;
    }

    private ParserFactory() {
    }
}
