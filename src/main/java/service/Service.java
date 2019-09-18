package service;

import dao.DaoException;

public interface Service<T> {
    void create(T obj) throws ServiceException, DaoException;

    T read(String id) throws ServiceException, DaoException;

    void update(T obj) throws ServiceException, DaoException;

    void delete(String id) throws ServiceException, DaoException;
}
