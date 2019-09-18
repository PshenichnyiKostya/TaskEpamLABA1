package dao;

import bean.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Dao client.
 */
public class DaoClient implements Dao<Client> {
    private static DaoClient ourInstance = new DaoClient();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    static DaoClient getInstance() {
        return ourInstance;
    }

    private List<Client> clientList = new ArrayList<>();

    private DaoClient() {
    }

    @Override
    public void delete(Client obj) throws DaoException {
        for (Client client : clientList) {
            if (client.equals(obj)) {
                clientList.remove(obj);
                return;
            }
        }
        throw new DaoException("This object is not exist");
    }

    @Override
    public void add(Client obj) throws DaoException {
        if (obj == null) throw new DaoException("Client is null in add method");
        for (Client client : clientList) {
            if (client.equals(obj)) {
                throw new DaoException("This obj in exist");
            }
        }
        clientList.add(obj);
    }

    @Override
    public Client get(String id) throws DaoException {
        for (Client client : clientList) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        throw new DaoException("This object is not exist");
    }

    @Override
    public void addAll(List<Client> list) throws DaoException {
        if (list == null) throw new DaoException("Client is null in addAll method");
        StringBuilder s = new StringBuilder();
        for (Client client : list) {
            for (Client client1 : clientList) {
                if (client.equals(client1)) {
                    throw new DaoException("Some of this obj is exist");
                }
            }
        }
        clientList.addAll(list);
    }

    /**
     * Gets client list.
     *
     * @return the client list
     */
    public List<Client> getClientList() {
        return clientList;
    }
}




