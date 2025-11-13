package com.app.threads;

public class BankTransactionSimulator {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(100);

        UserThread user3 = new UserThread(sharedAccount, 180, "User-C");
        UserThread user1 = new UserThread(sharedAccount, 80, "User-A");
        UserThread user2 = new UserThread(sharedAccount, 80, "User-B");

        user3.start();;
        user1.start();
        user2.start();
    }
}