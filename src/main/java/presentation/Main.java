package presentation;

import bean.Client;
import bean.Gender;
import dao.DaoClient;
import dao.DaoException;
import dao.DaoFactory;
import dao.SQLClientDao;
import org.xml.sax.SAXException;
import parser.DOMClientParser;
import parser.ParserException;
import parser.ParserFactory;
import service.ClientService;
import service.ServiceException;
import service.ServiceFactory;
import service.tag.ByDiscountAndFreeMiles;
import service.tag.ByFreeMiles;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Main.
 */
public class Main {
    /**
     * The constant logger.
     */

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws IOException, SAXException {
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
        daoClient.getClientList().addAll(clients);
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
        client.setGender(Gender.MALE);
        //Createl
        try {
            clientService.create(client);
        } catch (ServiceException | DaoException serviceException) {
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
        for (Client client1 : daoClient.getClientList()) {
            System.out.println(client1);
        }

        SQLClientDao sqlClientDao;
        try {

            sqlClientDao = new SQLClientDao();
            sqlClientDao.add(client);
            sqlClientDao.add(client);
//            sqlClientDao.delete(client);
//            sqlClientDao.get(client.getId());
        } catch (SQLException | DaoException e) {
            e.printStackTrace();
        }
    }


}

