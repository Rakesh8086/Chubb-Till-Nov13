package com.app.threads;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void withdraw(double amount, String user) {
        System.out.println(user + " is attempting to withdraw $" + amount);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (balance >= amount) {
            System.out.println(user + " proceeds: Current balance = " + balance);
            balance -= amount;
            System.out.println(user + " completed withdrawal. New balance = " + balance);
        } else {
            System.out.println(user + " cannot withdraw. Insufficient funds. Balance = " + balance);
        }
    }
}




