package com.app.hdfc;

class Bank {
    private String name;
    private double balance;

    public Bank(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean paySalary(Employee e) {
        if (balance >= e.getSalary()) {
            balance -= e.getSalary();
            System.out.println("Paid " + e.getName() + " " + e.getSalary());
            return true;
        } else {
            System.out.println("Insufficient balance to pay " + e.getName());
            return false;
        }
    }

    public double getRemainingBalance() {
        return balance;
    }
}