package service;

public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private final Service clientService = ClientService.getInstance();

    public Service getClientService() {
        return clientService;
    }

    private ServiceFactory() {
    }
}
