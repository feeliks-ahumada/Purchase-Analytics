package Instacart;

import Instacart.entities.Order;
import Instacart.entities.Counters;
import Instacart.ingestion.CSV;
import Instacart.processing.Statistics;
import Instacart.visualize.Report;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class PurchaseAnalytics {

    public static void main(String[] args) {
        if (args.length == 1) {
            String fileProducts = args[0];
            inline(fileProducts);
        } else if (args.length == 2) {
            String fileOrders = args[0];
            String fileProducts = args[1];
            filesGiven(fileOrders, fileProducts);
        } else {
            System.out.println("Wrong arguments...");
        }
    }

    private static void inline(String fileProducts) {
        Instant start = Instant.now();

        Map<Integer, Integer> products = CSV.getProductsDepartment(fileProducts);
        Map<Integer, Counters> summary = new TreeMap<>();

        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            Order order = new Order(line);
            Statistics.validateOrder(products, summary, order);
        }

        Report.toCsv(summary);

        Instant finish = Instant.now();
        Report.executionTime(Duration.between(start,finish).toMillis());
    }

    private static void filesGiven(String fileOrders, String fileProducts) {
        Instant start = Instant.now();

        Map<Integer, Integer> products = CSV.getProductsDepartment(fileProducts);
        List<Order> orderProducts = CSV.getOrders(fileOrders);

        Map<Integer, Counters> summary = Statistics.getSummary(products, orderProducts);

        Report.toCsv(summary);

        Instant finish = Instant.now();
        Report.executionTime(Duration.between(start,finish).toMillis());
    }
}
