package main.java.dao;

public class DaoFactory {
    private static DaoFactory ourInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    public

    private DaoFactory() {
    }
}
