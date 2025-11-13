package com.smartgateway.model;

public class User {
    private String username;
    private String password;
    private String upiPin;
    private String cardPin;
    private double balance;

    public User(String username, String password, String upiPin, String cardPin, double balance) {
        this.username = username;
        this.password = password;
        this.upiPin = upiPin;
        this.cardPin = cardPin;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUpiPin() {
        return upiPin;
    }

    public String getCardPin() {
        return cardPin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public boolean validateUpiPin(String inputPin) {
        return upiPin.equals(inputPin);
    }

    public boolean validateCardPin(String inputPin) {
        return cardPin.equals(inputPin);
    }

    public void deductAmount(double amount) {
        this.balance -= amount;
    }

    public void addAmount(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
