package service;

/**
 * The type Service factory.
 */
public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private final Service clientService = ClientService.getInstance();

    /**
     * Gets client service.
     *
     * @return the client service
     */
    public Service getClientService() {
        return clientService;
    }

    private ServiceFactory() {
    }
}
