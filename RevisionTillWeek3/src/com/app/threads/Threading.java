package com.app.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=1;i<=3;i++) {
            executor.submit(new Worker("Task " + i));
        }
		
		executor.shutdown();
	}
}
