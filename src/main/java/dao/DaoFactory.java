package dao;

/**
 * The type Dao factory.
 */
public class DaoFactory {
    private static DaoFactory ourInstance = new DaoFactory();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private final Dao daoClient = DaoClient.getInstance();

    /**
     * Gets dao for clients.
     *
     * @return the daoClient
     */
    public Dao getDaoClient() {
        return daoClient;
    }

    private DaoFactory() {
    }
}
