package com.app.orders;

import java.util.Queue;
import java.util.Random;

class OrderProcessor implements Runnable {
    private final Queue<Order> queue;

    public OrderProcessor(Queue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!queue.isEmpty()) {
            Order order = queue.poll();  // safely take next order
            if (order != null) {
                System.out.println(Thread.currentThread().getName() + " processing " + order);
                try {
                    Thread.sleep(random.nextInt(500) + 200); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " completed " + order);
            }
        }
    }
}
