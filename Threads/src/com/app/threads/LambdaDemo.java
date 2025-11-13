package com.app.threads;

import java.util.*;
import java.util.function.*;

public class LambdaDemo {
    public static void main(String[] args) {

        Runnable task = () -> System.out.println("Hello from a thread using Lambda");
        new Thread(task).start();

        List<String> names = Arrays.asList("AA", "AB", "BA", "BB");
        Collections.sort(names, (a, b) -> a.compareTo(b)); 
        System.out.println("Sorted names: " + names);

        MathOperation add = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;
        System.out.println("Add result: " + add.operate(5, 3));
        System.out.println("Multiply result: " + multiply.operate(5, 3));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 7 even? " + isEven.test(7));

        Function<String, Integer> len = str -> str.length();
        System.out.println("Length of 'Lambda' = " + len.apply("Lambda"));

        Greeting greet = getGreeting();
        greet.sayHello("AAAA");
    }

    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    @FunctionalInterface
    interface Greeting {
        void sayHello(String name);
    }

    static Greeting getGreeting() {
        return name -> System.out.println("Hi, " + name + "!");
    }
}
