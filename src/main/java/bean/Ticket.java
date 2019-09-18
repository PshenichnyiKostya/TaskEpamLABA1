package bean;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * The type Ticket.
 */
public class Ticket {
    private double price;
    private boolean baggage;
    private boolean food;
    private boolean cabinLag;
    private Rang rang;
    private double totalPrice;
    private Client client;

    /**
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBaggage() {
        return baggage;
    }

    public void setBaggage(boolean baggage) {
        this.baggage = baggage;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isCabinLag() {
        return cabinLag;
    }

    public void setCabinLag(boolean cabinLag) {
        this.cabinLag = cabinLag;
    }

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.getPrice(), getPrice()) == 0 &&
                isBaggage() == ticket.isBaggage() &&
                isFood() == ticket.isFood() &&
                isCabinLag() == ticket.isCabinLag() &&
                Double.compare(ticket.getTotalPrice(), getTotalPrice()) == 0 &&
                getRang() == ticket.getRang();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), isBaggage(), isFood(), isCabinLag(), getRang(), getTotalPrice());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ticket.class.getSimpleName() + "[", "]")
                .add("price=" + price)
                .add("baggage=" + baggage)
                .add("food=" + food)
                .add("cabinLag=" + cabinLag)
                .add("rang=" + rang)
                .add("totalPrice=" + totalPrice)
                .add("client=" + client.toString())
                .toString();
    }
}
