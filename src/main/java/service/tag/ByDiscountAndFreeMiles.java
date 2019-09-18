package service.tag;

import bean.Client;

import java.util.Comparator;

/**
 * The type By discount and free miles for sorting
 */
public class ByDiscountAndFreeMiles implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return Comparator.comparing(Client::getDiscount).thenComparing(Client::getFreeMiles).compare(o1, o2);
    }
}
