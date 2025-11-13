package com.app;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, Double> accounts = new HashMap<>();

    // Constructor to initialize some accounts
    public AccountService() {
        accounts.put("ACC123", 1000.0);
        accounts.put("ACC456", 500.0);
    }

    public boolean exists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public double getBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }

    public boolean debit(String accountNumber, double amount) {
        if (!exists(accountNumber)) return false;
        double balance = accounts.get(accountNumber);
        if (balance < amount) return false;
        accounts.put(accountNumber, balance - amount);
        return true;
    }

    public boolean credit(String accountNumber, double amount) {
        if (!exists(accountNumber)) return false;
        double balance = accounts.get(accountNumber);
        accounts.put(accountNumber, balance + amount);
        return true;
    }
}
