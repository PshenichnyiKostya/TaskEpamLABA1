package bean;

/**
 * The enum Rang.
 */
public enum Rang {
    /**
     * Business rang.
     */
    BUSINESS(100),
    /**
     * Economy rang.
     */
    ECONOMY(0);
    private double price;

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

    Rang(double price) {
        this.price = price;
    }

}
