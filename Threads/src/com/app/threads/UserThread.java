package com.app.threads;

class UserThread extends Thread {
    private BankAccount account;
    private double amount;
    private String userName;

    public UserThread(BankAccount account, double amount, String userName) {
        this.account = account;
        this.amount = amount;
        this.userName = userName;
    }

    @Override
    public void run() {
        account.withdraw(amount, userName);
    }
}