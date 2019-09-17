package main.java.dao;

import java.util.List;

public interface Dao<T> {

    void delete(T obj) throws DabException;

    void add(T obj) throws DabException;

    T get(long id) throws DabException;

    void addAll(List<T> list) throws DabException;
}
