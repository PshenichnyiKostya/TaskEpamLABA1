package service.tag;

import bean.Client;
import service.Finder;

import java.util.Comparator;

/**
 * The type By name for sort, find and etc. by this tag.
 */
public class ByName implements Comparator<Client>, Finder<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean find(Client obj, Object tag) {
        return obj.getName().equals(tag);
    }
}
