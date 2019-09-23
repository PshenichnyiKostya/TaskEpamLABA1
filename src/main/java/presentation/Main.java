package presentation;

import bean.Client;
import dao.DaoClient;
import dao.DaoException;
import dao.DaoFactory;
import org.apache.log4j.Logger;
import parser.DOMClientParser;
import parser.ParserException;
import parser.ParserFactory;
import service.ClientService;
import service.ServiceException;
import service.ServiceFactory;
import service.tag.ByDiscountAndFreeMiles;
import service.tag.ByFreeMiles;
import service.tag.ByName;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Main.
 */
public class Main {
    /**
     * The constant logger.
     */
    private static final Logger logger = Logger.getLogger(Main.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ParserFactory parserFactory = ParserFactory.getInstance();
        DOMClientParser domClientParser = (DOMClientParser) parserFactory.getDomClientParser();
        List<Client> clients = new ArrayList<>();
        try {
            clients = domClientParser.getData("/clients.xml");
        } catch (ParserException e) {
            e.printStackTrace();
        }
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        try {
            daoClient.addAll(clients);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = (ClientService) serviceFactory.getClientService();
        Client client = new Client();
        client.setId("ht220987");
        client.setDiscount(20);
        client.setFreeMiles(200);
        client.setLogin("asd");
        client.setName("Kostya");
        client.setPass("12345678Qwe");
        client.setSurname("Petrov");

        //Createl
        try {
            clientService.create(client);
        } catch (ServiceException | DaoException serviceException) {
            serviceException.printStackTrace();
        }

        //Read
        try {
            logger.info(clientService.read("ht220987"));
        } catch (DaoException serviceException) {
            serviceException.printStackTrace();
        }

        //Update
        client.setLogin("poit");
        try {
            clientService.update(client);
        } catch (ServiceException | DaoException serviceException) {
            serviceException.printStackTrace();
        }
        client.setPass("asdasdasdasdasd");


        //Find
        try {
            logger.info(clientService.find(new ByName(), "Kostya"));
        } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }

        //Sort
        try {
            clientService.sort(new ByFreeMiles());
        } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }

        //Sort by 2 args
        try {
            clientService.sort(new ByDiscountAndFreeMiles());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        //Delete
        try {
            clientService.delete("ht220987");
        } catch (DaoException serviceException) {
            serviceException.printStackTrace();
        }
        clients = daoClient.getClientList();
        clients.forEach(logger::info);

    }
}
