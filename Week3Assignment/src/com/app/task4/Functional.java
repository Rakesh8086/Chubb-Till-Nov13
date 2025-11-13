package com.app.task4;

import java.util.*;
import java.util.stream.Collectors;

public class Functional {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3, 6, 4);

        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)       
                .map(n -> n * n)               
                .sorted()                      
                .collect(Collectors.toList()); 

        System.out.println(evenSquares);
    }
}
