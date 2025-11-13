package com.smartgateway.app;

import com.smartgateway.exception.*;
import com.smartgateway.model.*;
import com.smartgateway.service.*;

import java.util.List;
import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();
        PaymentService paymentService = new PaymentService();
        UserService userService = new UserService();

        System.out.println("==SmartPayment Gateway==");

        try {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            User loggedUser = loginService.authenticate(username, password);
            System.out.println("Login successful, " + loggedUser.getUsername() + ".");
            System.out.println("Your current balance: " + loggedUser.getBalance());

            boolean flag = true;

            while(flag) {

                System.out.println("Available Beneficiaries:");
                List<User> allUsers = userService.getAllUsers();
                for(User u : allUsers) {
                    if(!u.getUsername().equalsIgnoreCase(loggedUser.getUsername())) {
                        System.out.println(" - " + u.getUsername());
                    }
                }

                System.out.print("Enter Beneficiary Username: ");
                String beneficiaryUsername = scanner.nextLine();
                
                if(username.equals(beneficiaryUsername)) {
                	System.out.print("Cannot make self transfer");
                }
                else {

	                System.out.println("Select Payment Method:");
	                System.out.println("1. UPI");
	                System.out.println("2. Credit Card");
	                System.out.print("Enter choice: ");
	                int choice = scanner.nextInt();
	
	                System.out.print("Enter Amount to Transfer: ");
	                double amount = scanner.nextDouble();
	                scanner.nextLine(); 
	
	                Payment payment = null;
	
	                if(choice == 1) {
	                    System.out.print("Enter UPI PIN: ");
	                    String upiPin = scanner.nextLine();
	                    payment = new UPIPayment(loggedUser, amount, upiPin);
	                } 
	                else if(choice == 2) {
	                    System.out.print("Enter Card PIN: ");
	                    String cardPin = scanner.nextLine();
	                    payment = new CreditCardPayment(loggedUser, amount, cardPin);
	                } 
	                else {
	                    System.out.println("Invalid choice. Transaction aborted.");
	                    continue;
	                }
	
	                try {
	                    PaymentResult result = paymentService.processPayment(loggedUser, beneficiaryUsername, payment);
	
	                    if(result.isSuccess()) {
	                        System.out.println("Payment Successful!");
	                        System.out.println(result.getMessage());
	                        System.out.println("Amount Transferred: ₹" + result.getChargedAmount());
	                        System.out.println("Your Updated Balance: ₹" + loggedUser.getBalance());
	                    }
	
	                } 
	                catch (BeneficiaryNotFoundException | InvalidPaymentDetailsException | InsufficientFundsException e) {
	                    System.out.println("Transaction Failed: " + e.getMessage());
	                }
                }
                
                System.out.print("Do you want to make another transaction? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (!response.equals("yes") && !response.equals("y")) {
                	flag = false;
                }
            }

        } 
        catch(InvalidCredentialsException e) {
            System.out.println("Login Failed: " + e.getMessage());
        } 
        catch(Exception e) {
            System.out.println("error occurred: " + e.getMessage());
        } 
        finally {
            System.out.println("Thank you for using SmartPayment Gateway");
            scanner.close();
        }
    }
}
