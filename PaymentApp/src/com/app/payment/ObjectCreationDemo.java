package com.app.payment;

public class ObjectCreationDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            String s = new String("Object " + i);
            if (i % 1000 == 0) {
                Thread.sleep(1000);
                System.out.println("Created " + i + " objects");
            }
        }
    }
}
