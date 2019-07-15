package Instacart.processing;

import Instacart.entities.Counters;
import Instacart.entities.Order;
import Instacart.entities.OrderByDepartment;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This class is for calculate results
 */
public class Statistics {

    /**
     * Getting the summary by department
     * @param products
     * @param orderProducts
     * @return Map of Counters related to each department
     */
    public static Map<Integer, Counters> getSummary(Map<Integer, Integer> products, List<Order> orderProducts) {
        Map<Integer, Counters> reportMap = new TreeMap<>();

        try {
            for (Order o :
                    orderProducts) {
                int dept = Objects.requireNonNull(products).get(o.getProductId());
                int firstOrder = o.getReordered() ? 0 : 1;
                Counters counters = reportMap.get(dept);
                if (counters == null) {
                    counters = new Counters(1, firstOrder);
                    reportMap.put(dept, counters);
                } else {
                    counters.setNumberOfOrders(counters.getNumberOfOrders() + 1);
                    counters.setNumberOfFirstOrders(counters.getNumberOfFirstOrders() + firstOrder);
                    reportMap.replace(dept, counters);
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return reportMap;
    }

    /**
     * Same functionality of getSummary but using streams and lambdas just for performance tests purpose =)
     * @param products
     * @param orderProducts
     * @return Map of Counters related to each department
     */
    public static Map<Integer, Counters>  getSummaryByStreams(Map<Integer, Integer> products, List<Order> orderProducts) {
        Map<Integer, Counters> groups = orderProducts.stream().parallel()
                .map( order ->
                        new OrderByDepartment(
                                order.getId(),
                                order.getProductId(),
                                products.get(order.getProductId()),
                                order.getReordered()))
                .collect(Collectors.groupingBy(OrderByDepartment::getDepartmentId, Collector.of(
                        () -> new int[3],
                        (result, order) -> {result[0]+=1; result[1]+=order.isReordered()?0:1; },
                        (result1, result2) -> {result1[0]+=result2[0];result1[1]+=result2[1]; return result1;},
                        result -> new Counters(result[0], result[1])
                )));

        return new TreeMap<>(groups);
    }

    /**
     * I'm using this for inline analysis but it's just for tests, thinking in scalability
     * @param products
     * @param reportMap
     * @param o
     */
    public static void validateOrder(Map<Integer, Integer> products, Map<Integer, Counters> reportMap, Order o) {
        int dept = Objects.requireNonNull(products).get(o.getProductId());
        int firstOrder = o.getReordered() ? 0 : 1;
        Counters counters = reportMap.get(dept);
        if (counters == null) {
            counters = new Counters(1, firstOrder);
            reportMap.put(dept, counters);
        } else {
            counters.setNumberOfOrders(counters.getNumberOfOrders() + 1);
            counters.setNumberOfFirstOrders(counters.getNumberOfFirstOrders() + firstOrder);
            reportMap.replace(dept, counters);
        }
    }
}
