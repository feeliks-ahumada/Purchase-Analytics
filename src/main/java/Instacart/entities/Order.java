package Instacart.entities;

public class Order {
    private int id;
    private int productId;
    private byte reordered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public byte getReordered() {
        return reordered;
    }

    public void setReordered(byte reordered) {
        this.reordered = reordered;
    }
}