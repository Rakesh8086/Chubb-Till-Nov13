package com.app.task2;

import java.util.concurrent.CompletableFuture;

public class User {
    public CompletableFuture<String> getUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(1000);
            return "User: AAA";
        });
    }

    private void simulateDelay(long ms) {
        try { 
        	Thread.sleep(ms); 
        } catch (InterruptedException e) { 
        	e.printStackTrace(); 
        }
    }
}
