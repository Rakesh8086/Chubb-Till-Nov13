package com.app.payment;

import java.io.*;
import java.util.*;

public class AccountFileReader {

	public static void processTransactions(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma and trim
                String[] parts = line.split(",");
                if (parts.length != 10) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                String senderName = parts[0].trim();
                String senderCountry = parts[1].trim();
                String senderAccNo = parts[2].trim();
                String senderIfsc = parts[3].trim();
                double senderTotalMoney = Double.parseDouble(parts[4].trim());

                double transferAmount = Double.parseDouble(parts[5].trim());

                String receiverName = parts[6].trim();
                String receiverCountry = parts[7].trim();
                String receiverAccNo = parts[8].trim();
                String receiverIfsc = parts[9].trim();

                Account sender = new Account(senderName, senderCountry, senderAccNo, senderIfsc, senderTotalMoney);
                Account receiver = new Account(receiverName, receiverCountry, receiverAccNo, receiverIfsc, 0.0);

                performTransfer(sender, receiver, transferAmount);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private static void performTransfer(Account sender, Account receiver, double amount) {
        System.out.println("Processing transfer from " + sender.getName() + " to " + receiver.getName());
        System.out.println("Transfer amount: " + amount);

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance in sender’s account.");
            return;
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        System.out.println("Transfer successful!");
        System.out.println("Sender:   " + sender);
        System.out.println("Receiver: " + receiver);
        System.out.println("-------------------------------------------------\n");
    }
}
