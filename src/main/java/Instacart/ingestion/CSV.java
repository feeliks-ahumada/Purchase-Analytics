package Instacart.ingestion;

import Instacart.entities.Order;
import Instacart.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSV {
    private static final String COMMA = ",";

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

    private static Function<String, Order> mapToOrderItem = (line) -> {

        String[] rows = line.split(COMMA);
        Order instance = new Order();
        instance.setId(Integer.parseInt(rows[0]));
        instance.setProductId(Integer.parseInt(rows[1]));
        instance.setReordered(Byte.parseByte(rows[3]));

        return instance;
    };


    private static Function<String, Product> mapToProductItem = (line) -> {

//        int sub = line.indexOf("\"");
//        String name, id, aisleId, departmentId;
//        if ( sub > 0) {
//            id = line.substring(0, sub - 1);
//            sub = line.lastIndexOf("\"");
//            name = line.substring(id.length() + 2, sub);
//            aisleId = line.substring(sub + 2, line.indexOf(',',sub + 2));
//            departmentId = line.substring(line.lastIndexOf(',') + 1);
//        } else {
//            String[] rows = line.split(COMMA);
//            id = rows[0];
//            departmentId = rows[3];
//        }

        Product instance = new Product();
        instance.setId(Integer.parseInt(line.substring(0, line.indexOf(","))));
        instance.setDepartmentId(Integer.parseInt(line.substring(line.lastIndexOf(',') + 1)));

        return instance;
    };
}
