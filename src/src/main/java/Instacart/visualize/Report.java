package Instacart.visualize;

import Instacart.entities.Counters;

import java.util.Map;

import static java.lang.System.out;

/**
 * Class for print out the report on screen
 */
public class Report {
    public static void toCsv(Map<Integer, Counters> report) {

        out.println("department_id,number_of_orders,number_of_first_orders,percentage");

        report.forEach((k,v)->out.printf("%d,%d,%d,%.2f%n",
                k,
                v.getNumberOfOrders(),
                v.getNumberOfFirstOrders(),
                v.getPercentage()));
    }

    public static void executionTime(long toMillis) {
        //out.println(String.format("Execution time: %d", toMillis));
    }
}
