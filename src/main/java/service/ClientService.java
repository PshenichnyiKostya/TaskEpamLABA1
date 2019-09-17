package service;

import bean.Client;
import dao.DaoClient;
import dao.DaoFactory;
import service.tag.ByFreeMiles;
import service.tag.ByName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientService implements Service<Client> {
    private static ClientService ourInstance = new ClientService();

    public static ClientService getInstance() {
        return ourInstance;
    }

    private ClientService() {
    }


    @Override
    public void create(Client obj) throws ServiceExeption {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (existAllParamClient(obj)) {
            for (Client client : daoClient.getClientList()) {
                if (client.equals(obj) || client.getId().equals(obj.getId())) {
                    throw new ServiceExeption("Such obj is exist");
                }
            }
            daoClient.getClientList().add(obj);
        } else
            throw new ServiceExeption("Not enough param");
    }

    private boolean existAllParamClient(Client client) {
        if ((client.getId() != null) &&
                (client.getName() != null) &&
                (client.getLogin() != null) &&
                (client.getPass() != null) &&
                (client.getSurname() != null)) {
            return true;
        } else
            return false;
    }

    @Override
    public Client read(String id) throws ServiceExeption {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        for (Client client : daoClient.getClientList()) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        throw new ServiceExeption("No such client");
    }

    @Override
    public void update(Client client) throws ServiceExeption {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (existAllParamClient(client)) {
            for (Client client1 : daoClient.getClientList()) {
                if (client1.getId().equals(client.getId())) {
                    daoClient.getClientList().remove(client1);
                    Client client2 = new Client(client);
                    daoClient.getClientList().add(client2);
                    return;
                }
            }
            throw new ServiceExeption("No such client");
        }
        throw new ServiceExeption("Not enough client param");
    }

    @Override
    public void delete(String id) throws ServiceExeption {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        for (Client client : daoClient.getClientList()) {
            if (client.getId().equals(id)) {
                daoClient.getClientList().remove(client);
                return;
            }
        }
        throw new ServiceExeption("No such obj");
    }

    public void sort(Comparator<Client> comparator) throws ServiceExeption {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (comparator == null) throw new ServiceExeption("Comparator is null");

        if (comparator instanceof ByName) {
            daoClient.getClientList().sort(new ByName());
        } else if (comparator instanceof ByFreeMiles) {
            daoClient.getClientList().sort(new ByFreeMiles());
        } else throw new ServiceExeption("No such comparator");

    }

    public List<Client> find(Finder<Client> finder, Object tag) throws ServiceExeption {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (finder == null) throw new ServiceExeption("Finder is null");
        List<Client> found = new ArrayList<>();
        for (Client client : daoClient.getClientList()) {
            if (finder.find(client, tag)) {
                found.add(client);
            }
        }
        if (found.isEmpty()) throw new ServiceExeption("No clients by our tag");
        return found;
    }
}
