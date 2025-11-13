package com.app.threads;

public class Worker implements Runnable {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " finished by " + Thread.currentThread().getName());
    }
}
