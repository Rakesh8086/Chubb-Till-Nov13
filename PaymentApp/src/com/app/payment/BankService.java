package com.app.payment;

import java.util.List;

public class BankService {

    public static boolean transferFunds(List<Account> accounts, String fromAccNo, String toAccNo, double amount) {
        Account sender = null;
        Account receiver = null;

        // Find both accounts
        for (Account acc : accounts) {
            if (acc.getAccNo().equals(fromAccNo)) {
                sender = acc;
            } else if (acc.getAccNo().equals(toAccNo)) {
                receiver = acc;
            }
        }

        // Validate
        if (sender == null || receiver == null) {
            System.out.println("Either sender or receiver account not found.");
            return false;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance in sender's account.");
            return false;
        }

        // Perform transfer
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        System.out.println("Transfer successful!");
        System.out.printf("New balance of %s: %.2f%n", sender.getName(), sender.getBalance());
        System.out.printf("New balance of %s: %.2f%n", receiver.getName(), receiver.getBalance());

        return true;
    }
}
