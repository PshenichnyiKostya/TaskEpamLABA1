package bean;

public enum Rang {
    BUSINESS(100),
    ECONOMY(0);
    private double price;
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    Rang(double price) {
        this.price = price;
    }

}
