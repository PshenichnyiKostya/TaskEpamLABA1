package parser;

import java.util.List;

public interface XMLParser<T> {
    List<T> getData(String path) throws ParserException;
}
