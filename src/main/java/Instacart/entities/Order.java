package Instacart.entities;

/**
 * Order entity
 */
public class Order {
    private int id;
    private int productId;
    private boolean reordered;

    public Order(String line) {
        String[] cols = line.split(",");
        if (cols.length == 4) {
            this.id = Integer.parseInt(cols[0]);
            this.productId = Integer.parseInt(cols[1]);
            this.reordered = Integer.parseInt(cols[3]) != 0;
        }
    }

    public Order() {}

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

    public boolean getReordered() {
        return reordered;
    }

    public void setReordered(boolean reordered) {
        this.reordered = reordered;
    }
}