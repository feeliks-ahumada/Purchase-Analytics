package Instacart.entities;

public class OrderByDepartment {
    private int departmentId;
    private int orderId;
    private byte reordered;

    public OrderByDepartment(int departmentId, int orderId, byte reordered) {
        this.departmentId = departmentId;
        this.orderId = orderId;
        this.reordered = reordered;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public byte getReordered() {
        return reordered;
    }

    public void setReordered(byte reordered) {
        this.reordered = reordered;
    }
}
