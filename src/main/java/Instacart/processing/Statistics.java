package Instacart.processing;

import Instacart.entities.Order;
import Instacart.entities.OrderByDepartment;
import Instacart.entities.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Statistics {

    public static List<Report> getSummary(List<Order> orderProducts, Map<Integer, Integer> productsSubset) {

        Stream<OrderByDepartment> orderByDepartments = orderProducts.stream()
                .map( order ->
                        new OrderByDepartment(productsSubset.getOrDefault(order.getProductId(), 0)
                                , order.getId()
                                , order.getReordered()));


//        Map<Integer, List<OrderByDepartment>> summary = orderByDepartments
//                .collect(Collectors.groupingBy(OrderByDepartment::getDepartmentId))



        return new ArrayList<>();
    }
}
