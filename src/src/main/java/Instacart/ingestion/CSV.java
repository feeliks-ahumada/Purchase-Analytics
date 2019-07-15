package Instacart.ingestion;

import Instacart.entities.Order;
import Instacart.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * .csv loader
 */
public class CSV {
    private static final String COMMA = ",";

    /**
     * Products parser
     * @param fileProducts
     * @return List of products
     */
    public static List<Product> getProducts(String fileProducts) {
        List<Product> inputList = new ArrayList<>();

        try {
            File inputFile = new File(fileProducts);
            InputStream inputStream = new FileInputStream(inputFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            inputList = reader.lines().skip(1).map(mapToProductItem).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return inputList;
    }

    /**
     * Load product-department relationship
     * @param filePath
     * @return Map of Integers
     */
    public static Map<Integer, Integer> getProductsDepartment(String filePath) {
        try {
            File inputFile = new File(filePath);
            InputStream inputStream = new FileInputStream(inputFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            //I'm ignoring the others fields of product catalog because are irrelevant for the procedure
            return reader.lines().skip(1).collect(Collectors.toMap(
                    l -> Integer.parseInt(l.substring(0, l.indexOf(","))),
                    l -> Integer.parseInt(l.substring(l.lastIndexOf(',') + 1))
            ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Orders parser
     * @param fileProductsPrior
     * @return List of Orders
     */
    public static List<Order> getOrders(String fileProductsPrior) {
        List<Order> inputList = new ArrayList<>();

        try {
            File inputFile = new File(fileProductsPrior);
            InputStream inputStream = new FileInputStream(inputFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            inputList = reader.lines().skip(1).map(mapToOrderItem).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return inputList;
    }

    /**
     * Function used in parse of Order items
     */
    private static Function<String, Order> mapToOrderItem = (line) -> {
        String[] rows = line.split(COMMA);
        Order instance = new Order();
        instance.setId(Integer.parseInt(rows[0]));
        instance.setProductId(Integer.parseInt(rows[1]));
        int reordered = Integer.parseInt(rows[3]);
        instance.setReordered(reordered != 0);

        return instance;
    };

    /**
     * Function used in parse of Product items
     */
    private static Function<String, Product> mapToProductItem = (line) -> {
        Product instance = new Product();
        instance.setId(Integer.parseInt(line.substring(0, line.indexOf(","))));
        instance.setDepartmentId(Integer.parseInt(line.substring(line.lastIndexOf(',') + 1)));

        return instance;
    };
}
