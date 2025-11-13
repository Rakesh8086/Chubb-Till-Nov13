package com.app.task2;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        User userService = new User();
        Order orderService = new Order();
        Payment paymentService = new Payment();
        
        // A CompletableFuture lets you decide what to do next automatically 
        // asynchronously and non-blockingly.
        CompletableFuture<String> userFuture = userService.getUserDetails();
        CompletableFuture<String> orderFuture = orderService.getOrderDetails();
        CompletableFuture<String> paymentFuture = paymentService.getPaymentStatus();

        // Combine all three
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(userFuture, orderFuture, paymentFuture);

        // prints the results only after all are done
        allFutures.thenRun(() -> {
            try {
                System.out.println(userFuture.get());
                System.out.println(orderFuture.get());
                System.out.println(paymentFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        
        // without this join, the main thread might end before the other 3 that are running
        allFutures.join();

        System.out.println("All async operations completed!");
    }
}
