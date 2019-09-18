package parser;

/**
 * The type Parser exception.
 */
public class ParserException extends Exception {
    /**
     * Instantiates a new Parser exception.
     */
    public ParserException() {
    }

    /**
     * Instantiates a new Parser exception.
     *
     * @param message the message
     */
    public ParserException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Parser exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Parser exception.
     *
     * @param cause the cause
     */
    public ParserException(Throwable cause) {
        super(cause);
    }
}
