package com.app.payment;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        List<Accounts> accounts = Arrays.asList(
                new Accounts(101, "AAA", 500.00),
                new Accounts(102, "BBB", 600.00),
                new Accounts(103, "CCC", 700.00),
                new Accounts(104, "DDD", 800.00)
        );

        Function<Accounts, Integer> accNo = Accounts::getAccountNo;

        List<Accounts> sortedAsc = accounts.stream()
                .sorted(Comparator.comparing(accNo)) 
                .collect(Collectors.toList());

        System.out.println("ascending:");
        sortedAsc.forEach(System.out::println);
        
        List<Accounts> sortedDesc = accounts.stream()
                .sorted(Comparator.comparing(accNo).reversed())
                .collect(Collectors.toList());
        
        System.out.println("descending:");
        sortedDesc.forEach(System.out::println);
        
        
        Function<Accounts, Double> bal = Accounts::getBalance;

        List<Accounts> sortedBal = accounts.stream()
                .sorted(Comparator.comparing(bal)) 
                .collect(Collectors.toList());
        
        System.out.println("Balance:");
        sortedBal.forEach(System.out::println);
    }
}