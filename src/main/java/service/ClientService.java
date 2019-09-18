package service;

import bean.Client;
import dao.DaoClient;
import dao.DaoException;
import dao.DaoFactory;
import service.tag.ByFreeMiles;
import service.tag.ByName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Client service.
 */
public class ClientService implements Service<Client> {
    private static ClientService ourInstance = new ClientService();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ClientService getInstance() {
        return ourInstance;
    }

    private ClientService() {
    }


    @Override
    public void create(Client obj) throws ServiceException, DaoException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (existAllParamClient(obj)) {
            for (Client client : daoClient.getClientList()) {
                if (client.getId().equals(obj.getId())) {
                    throw new ServiceException("Such obj is exist");
                }
            }
            daoClient.add(obj);
        } else
            throw new ServiceException("Not enough param");
    }

    private boolean existAllParamClient(Client client) {
        return (client.getId() != null) &&
                (client.getName() != null) &&
                (client.getLogin() != null) &&
                (client.getPass() != null) &&
                (client.getSurname() != null);
    }

    @Override
    public Client read(String id) throws DaoException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        return daoClient.get(id);
    }

    @Override
    public void update(Client client) throws ServiceException, DaoException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (existAllParamClient(client)) {
            for (Client client1 : daoClient.getClientList()) {
                if (client1.getId().equals(client.getId())) {
                    daoClient.delete(client1);
                    Client client2 = new Client(client);
                    daoClient.add(client2);
                    return;
                }
            }
            throw new ServiceException("No such client");
        }
        throw new ServiceException("Not enough client param");
    }

    @Override
    public void delete(String id) throws DaoException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        Client client = daoClient.get(id);
        daoClient.delete(client);
    }

    /**
     * Sort.
     *
     * @param comparator the comparator for sorting
     * @throws ServiceException the service exception
     */
    public void sort(Comparator<Client> comparator) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (comparator == null) throw new ServiceException("Comparator is null");

        if (comparator instanceof ByName) {
            daoClient.getClientList().sort(new ByName());
        } else if (comparator instanceof ByFreeMiles) {
            daoClient.getClientList().sort(new ByFreeMiles());
        } else throw new ServiceException("No such comparator");

    }

    /**
     * Find list.
     *
     * @param finder the finder for find obj
     * @param tag    the tag-criteria for finding
     * @return the list of found clients
     * @throws ServiceException the service exception
     */
    public List<Client> find(Finder<Client> finder, Object tag) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DaoClient daoClient = (DaoClient) daoFactory.getDaoClient();
        if (finder == null) throw new ServiceException("Finder is null");
        List<Client> found = new ArrayList<>();
        for (Client client : daoClient.getClientList()) {
            if (finder.find(client, tag)) {
                found.add(client);
            }
        }
        if (found.isEmpty()) throw new ServiceException("No clients by our tag");
        return found;
    }
}
