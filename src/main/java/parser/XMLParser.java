package parser;

import java.util.List;

/**
 * The interface Xml parser.
 *
 * @param <T> the type parameter
 */
public interface XMLParser<T> {
    /**
     * Gets data.
     *
     * @param path the path of XML file
     * @return the data
     * @throws ParserException the parser exception
     */

    List<T> getData(String path) throws ParserException;
}
