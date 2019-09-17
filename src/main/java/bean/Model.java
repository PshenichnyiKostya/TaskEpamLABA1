package bean;

public enum Model {
    BOEING(10000, 100),
    EMBRAER(11000, 150);


    private double weight;
    private int seats;


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSeats() {
        return seats;
    }

    Model(double weight, int seats) {
        this.weight = weight;
        this.seats = seats;
    }
}
