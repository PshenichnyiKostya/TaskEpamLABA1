package dao;

public class DaoFactory {
    private static DaoFactory ourInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private final Dao daoClient = DaoClient.getInstance();

    public Dao getDaoClient() {
        return daoClient;
    }

    private DaoFactory() {
    }
}
