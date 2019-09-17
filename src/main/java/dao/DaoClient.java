package main.java.dao;

import main.java.bean.Client;

import java.util.ArrayList;
import java.util.List;

public class DaoClient implements Dao<Client> {
    private static DaoClient ourInstance = new DaoClient();

    public static DaoClient getInstance() {
        return ourInstance;
    }

    private List<Client> clientList = new ArrayList<>();

    private DaoClient() {
    }

    @Override
    public void delete(Client obj) throws DabException {
        for (Client client : clientList) {
            if (client.equals(obj)) {
                clientList.remove(obj);
                return;
            }
        }
        throw new DabException("This object is not exist");
    }

    @Override
    public void add(Client obj) throws DabException {
        if (obj == null) throw new DabException("Client is null in add method");
        for (Client client : clientList) {
            if (client.equals(obj)) {
                throw new DabException("This obj in DAO");
            }
        }
        clientList.add(obj);
    }

    @Override
    public Client get(long id) throws DabException {
        for (Client client : clientList) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new DabException("This object is not exist");
    }

    @Override
    public void addAll(List<Client> list) throws DabException {
        if (list == null) throw new DabException("Client is null in addAll method");
        StringBuilder s = new StringBuilder();
        for (Client client : list) {
            for (Client client1 : clientList) {
                if (client.equals(client1)) {
                    throw new DabException("Some of this obj is exist");
                }
            }
        }
        clientList.addAll(list);
    }
}




