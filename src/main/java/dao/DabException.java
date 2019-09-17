package main.java.dao;

public class DabException extends Exception {

    public DabException() {
    }

    public DabException(String message) {
        super(message);
    }

    public DabException(String message, Throwable cause) {
        super(message, cause);
    }

    public DabException(Throwable cause) {
        super(cause);
    }
}
