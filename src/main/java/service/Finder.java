package service;

public interface Finder<T> {
    boolean find(T obj, Object tag);
}
