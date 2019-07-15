package Instacart.ingestion;

import Instacart.entities.Order;
import Instacart.entities.Product;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CSVTest {

    @Test
    public void getProducts() {
        String productsFile = getClass().getResource("products.csv").getPath();
        List<Product> productsList = CSV.getProducts(productsFile);

        assertEquals(2, productsList.size());
    }

    @Test
    public void getProductsDepartment() {
        String productsFile = getClass().getResource("products.csv").getPath();
        Map<Integer, Integer> products =CSV.getProductsDepartment(productsFile);

        assertEquals(2, products.size());
    }

    @Test
    public void getOrders() {
        String ordersFile = getClass().getResource("orders.csv").getPath();
        List<Order> products =CSV.getOrders(ordersFile);

        assertEquals(5, products.size());
    }
}