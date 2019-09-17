package service;

public class ServiceExeption extends Exception {
    public ServiceExeption() {
    }

    public ServiceExeption(String message) {
        super(message);
    }

    public ServiceExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceExeption(Throwable cause) {
        super(cause);
    }
}
