package Instacart;

import Instacart.entities.Order;
import Instacart.entities.Product;
import Instacart.ingestion.CSV;
import Instacart.processing.Statistics;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PurchaseAnalytics {
    public static void main(String[] args) {
        String fileOrders = "/Users/include/Downloads/instacart_2017_05_01/orders.csv";
        String fileProducts = "/Users/include/Downloads/instacart_2017_05_01/products.csv";

//        long lineCount = 0;
//        try {
//            lineCount = Files.lines(Paths.get(fileOrders)).count();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }


        List<Product> productsCatalog = CSV.getProducts(fileProducts);
        List<Order> orderProducts = CSV.getOrders(fileOrders);


        Set productsInOrders = orderProducts.stream().map(Order::getProductId).collect(Collectors.toSet());
        Map<Integer, Integer> productsSubset = productsCatalog.stream()
                .filter(product -> productsInOrders.contains(product.getId()))
                .collect(Collectors.toMap(Product::getId, Product::getDepartmentId));


        Statistics.getSummary(orderProducts, productsSubset);


        System.out.println("Done!");

    }
}
