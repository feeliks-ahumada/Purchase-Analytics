package Instacart.entities;

public class Report {
    private int departmentId;
    private int numberOfOrders;
    private int numberOfFirstOrders;
    private float percentage;

    public Report(int departmentId, int numberOfOrders, int numberOfFirstOrders, float percentage) {
        this.departmentId = departmentId;
        this.numberOfOrders = numberOfOrders;
        this.numberOfFirstOrders = numberOfFirstOrders;
        this.percentage = percentage;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
