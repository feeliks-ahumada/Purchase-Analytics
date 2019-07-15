package Instacart.processing;

import Instacart.entities.Counters;
import Instacart.entities.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StatisticsTest {



    @Test
    public void getSummary() {
        Map<Integer, Integer> products = new HashMap<>();
        products.put(1,19);
        products.put(2,13);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("2,1,1,1"));
        orders.add(new Order("2,1,2,1"));
        orders.add(new Order("3,2,1,1"));
        orders.add(new Order("3,2,2,0"));

        Map<Integer, Counters> result = Statistics.getSummary(products, orders);

        assertNotNull(result);

        Counters row1 = result.get(19);
        assertEquals(2, row1.getNumberOfOrders());
        assertEquals(0, row1.getNumberOfFirstOrders());
        assertEquals(0.0, row1.getPercentage(),0);

        Counters row2 = result.get(13);
        assertEquals(2, row2.getNumberOfOrders());
        assertEquals(1, row2.getNumberOfFirstOrders());
        assertEquals(0.5, row2.getPercentage(),0);
    }

    @Test
    public void getSummaryByStreams() {
        Map<Integer, Integer> products = new HashMap<>();
        products.put(1,19);
        products.put(2,13);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("2,1,1,1"));
        orders.add(new Order("2,1,2,1"));
        orders.add(new Order("3,2,1,1"));
        orders.add(new Order("3,2,2,0"));

        Map<Integer, Counters> result = Statistics.getSummaryByStreams(products, orders);

        assertNotNull(result);

        Counters row1 = result.get(19);
        assertEquals(2, row1.getNumberOfOrders());
        assertEquals(0, row1.getNumberOfFirstOrders());
        assertEquals(0.0, row1.getPercentage(),0);

        Counters row2 = result.get(13);
        assertEquals(2, row2.getNumberOfOrders());
        assertEquals(1, row2.getNumberOfFirstOrders());
        assertEquals(0.5, row2.getPercentage(),0);
    }
}