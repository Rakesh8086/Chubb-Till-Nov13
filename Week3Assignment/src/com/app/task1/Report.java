package com.app.task1;

import java.util.*;
import java.util.stream.*;

public class Report {

    public void printSummary(List<Sale> sales) {

        double totalRevenue = sales.stream()
                .mapToDouble(Sale::getTotalAmount)
                .sum();
        System.out.println("Total Revenue = " + totalRevenue);

        sales.stream()
                .mapToDouble(Sale::getTotalAmount)
                .average()
                .ifPresent(avg -> System.out.println("Average Sale Amount = " + avg));

        sales.stream()
                .max(Comparator.comparingDouble(Sale::getTotalAmount))
                .ifPresent(max -> System.out.println("Max Sale = " + max));

        sales.stream()
                .min(Comparator.comparingDouble(Sale::getTotalAmount))
                .ifPresent(min -> System.out.println("Min Sale = " + min));

        System.out.println("Category Wise : ");
        Map<String, Double> revenueByCategory = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getCategory,
                        Collectors.summingDouble(Sale::getTotalAmount)));

        revenueByCategory.forEach((cat, sum) ->
                System.out.println(cat + " = " + sum));
    }
}