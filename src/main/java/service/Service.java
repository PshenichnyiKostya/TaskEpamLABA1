package service;

public interface Service<T> {
    void create(T obj) throws ServiceExeption;

    T read(String id) throws ServiceExeption;

    void update(T obj) throws ServiceExeption;

    void delete(String id) throws ServiceExeption;
}
