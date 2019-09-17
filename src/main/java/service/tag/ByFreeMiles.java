package service.tag;

import bean.Client;
import service.Finder;

import java.util.Comparator;

public class ByFreeMiles implements Comparator<Client>, Finder<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return Double.compare(o1.getFreeMiles(), o2.getFreeMiles());
    }

    @Override
    public boolean find(Client obj, Object tag) {
        return Double.valueOf(obj.getFreeMiles()).equals(tag);
    }
}
