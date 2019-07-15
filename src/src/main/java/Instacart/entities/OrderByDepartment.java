package Instacart.entities;

/**
 * Used in the streams summary
 */
public class OrderByDepartment {
    private int orderId;
    private int productId;
    private int departmentId;
    private boolean reordered;

    public OrderByDepartment(int orderId, int productId, int departmentId, boolean reordered) {
        this.orderId = orderId;
        this.productId = productId;
        this.departmentId = departmentId;
        this.reordered = reordered;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() { return productId; }

    public void setProductId(int productId) { this.productId = productId; }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public boolean isReordered() {
        return reordered;
    }

    public void setReordered(boolean reordered) {
        this.reordered = reordered;
    }


}
