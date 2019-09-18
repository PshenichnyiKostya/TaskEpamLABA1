package service;

import dao.DaoException;

/**
 * The interface Service.
 *
 * @param <T> the type parameter
 */
public interface Service<T> {
    /**
     * Create.
     *
     * @param obj the obj try to ccreate
     * @throws ServiceException the service exception
     * @throws DaoException     the dao exception
     */
    void create(T obj) throws ServiceException, DaoException;

    /**
     * Read t.
     *
     * @param id the id
     * @return the t
     * @throws ServiceException the service exception
     * @throws DaoException     the dao exception
     */
    T read(String id) throws ServiceException, DaoException;

    /**
     * Update.
     *
     * @param obj the obj try to update
     * @throws ServiceException the service exception
     * @throws DaoException     the dao exception
     */
    void update(T obj) throws ServiceException, DaoException;

    /**
     * Delete.
     *
     * @param id the id
     * @throws ServiceException the service exception
     * @throws DaoException     the dao exception
     */
    void delete(String id) throws ServiceException, DaoException;
}
