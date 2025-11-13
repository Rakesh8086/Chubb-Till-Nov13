package com.app.task2;

import java.util.concurrent.CompletableFuture;

public class Payment {
    public CompletableFuture<String> getPaymentStatus() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(2000);
            return "Payment: Successfully done";
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
