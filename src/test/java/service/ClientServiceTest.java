package service;

import bean.Client;
import bean.Gender;
import dao.DaoClient;
import dao.DaoException;
import dao.DaoFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import parser.DOMClientParser;
import parser.ParserException;
import parser.ParserFactory;
import service.tag.ByFreeMiles;
import service.tag.ByName;

import java.util.List;

public class ClientServiceTest {
    public static DaoFactory daoFactory=DaoFactory.getInstance();
    public static DaoClient daoClient= (DaoClient) daoFactory.getDaoClient();

    public static ClientService service = ClientService.getInstance();

    @BeforeClass
    public static void qwe() throws ParserException {
        ParserFactory parserFactory = ParserFactory.getInstance();
        DOMClientParser domClientParser = (DOMClientParser) parserFactory.getDomClientParser();
        List<Client> clients= domClientParser.getData("/clients.xml");
        daoClient.getClientList().addAll(clients);
    }

    @Test
    public void read() throws DaoException {
        Client client2=new Client();
        client2.setId("hp353425");
        Client client = service.read("hp353425");
        Assert.assertEquals(client.getId(),client2.getId() );
    }

    @Test
    public void update() throws ServiceException, DaoException {
        Client client=new Client();
        client.setId("hp353425");
        client.setFreeMiles(800);
        client.setGender(Gender.MALE);
        client.setDiscount(90);
        client.setSurname("asd");
        client.setName("asdas");
        client.setLogin("Asdasda");
        client.setPass("asdaqw12qfdw");
        service.update(client);
        Assert.assertEquals(service.read("hp353425").getFreeMiles(),800,0.00001);
    }

    @Test(expected = DaoException.class)
    public void delete() throws DaoException {
        service.delete("hp353425");
        Assert.assertEquals(service.read("hp353425"),null);
    }

    @Test
    public void create() throws ServiceException, DaoException {
        Client client = new Client();
        client.setId("ht220987");
        client.setDiscount(20);
        client.setFreeMiles(200);
        client.setLogin("asd");
        client.setName("Kostya");
        client.setPass("12345678Qwe");
        client.setSurname("Petrov");
        client.setGender(Gender.MALE);
        service.create(client);
        Assert.assertEquals(client,service.read("ht220987"));

    }




    @Test
    public void sort() throws ServiceException {
        service.sort(new ByFreeMiles());
        boolean test = true;
        for (int i = 1; i < daoClient.getClientList().size(); i++) {
            if (daoClient.getClientList().get(i).getFreeMiles()<daoClient.getClientList().get(i-1).getFreeMiles()){
                test=false;
            }
        }
        Assert.assertTrue(test);
    }

    @Test
    public void find() throws ServiceException {
        Assert.assertEquals(service.find(new ByName(),"Pasha").size(),1);
    }
}