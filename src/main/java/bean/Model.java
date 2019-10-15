package bean;

/**
 * The enum Model.
 */
public enum Model {
    /**
     * Boeing model.
     */
    BOEING(10000, 100),
    /**
     * Embraer model.
     */
    EMBRAER(11000, 150);

    private double weight;
    private int seats;


    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets seats.
     *
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    Model(double weight, int seats) {
        this.weight = weight;
        this.seats = seats;
    }


}
