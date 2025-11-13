package com.app.orders;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();
        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            orderQueue.add(new Order(i, "Item-" + (random.nextInt(5) + 1)));
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // At max only 3 threads will be reused no matter how many tasks you submit
        // very very important
        for (int i = 0; i < 3; i++) {
            executor.submit(new OrderProcessor(orderQueue));
        }

        // Step 4: Graceful shutdown
        executor.shutdown();
        System.out.println("All workers started. Main thread is done.");
    }
}