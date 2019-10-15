package dao;

import java.util.List;

/**
 * The interface Dao.
 *
 * @param <T> the type parameter
 */
public interface Dao<T> {

    /**
     * Delete.
     *
     * @param obj the obj to delete
     * @throws DaoException the dao exception
     */
    void delete(T obj) throws DaoException;

    /**
     * Add.
     *
     * @param obj the obj to add
     * @throws DaoException the dao exception
     */
    void add(T obj) throws DaoException;

    /**
     * Get t.
     *
     * @param id the id of dao's obj
     * @return the T(type parameter)
     * @throws DaoException the dao exception
     */
    T get(String id) throws DaoException;
}
