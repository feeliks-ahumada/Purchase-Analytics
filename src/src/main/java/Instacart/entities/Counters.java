package Instacart.entities;

/**
 * Represents the columns of the final report
 */
public class Counters {
    private int numberOfOrders;
    private int numberOfFirstOrders;

    public Counters(int numberOfOrders, int numberOfFirstOrders) {
        this.numberOfOrders = numberOfOrders;
        this.numberOfFirstOrders = numberOfFirstOrders;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public int getNumberOfFirstOrders() {
        return numberOfFirstOrders;
    }

    public void setNumberOfFirstOrders(int numberOfFirstOrders) {
        this.numberOfFirstOrders = numberOfFirstOrders;
    }

    public float getPercentage() {
        if (numberOfOrders == 0) return 0;

        return (float)numberOfFirstOrders / (float)numberOfOrders;
    }
}
