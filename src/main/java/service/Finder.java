package service;

/**
 * The interface Finder.
 *
 * @param <T> the type parameter
 */
public interface Finder<T> {
    /**
     * Find boolean.
     *
     * @param obj the type of obj which we try to find
     * @param tag the tag for finding
     * @return the boolean
     */
    boolean find(T obj, Object tag);
}
