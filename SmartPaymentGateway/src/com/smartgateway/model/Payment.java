package com.smartgateway.model;

import com.smartgateway.exception.*;


public abstract class Payment {
    protected User user;
    protected double amount;

    public Payment(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }


    public final PaymentResult processPayment() throws InvalidPaymentDetailsException, InsufficientFundsException {
        validateDetails();       
        verifyFunds();          
        deductFunds();        
        
        return new PaymentResult(true, "Payment successful via " + this.getClass().getSimpleName(), amount);
    }

    protected abstract void validateDetails() throws InvalidPaymentDetailsException;

    private void verifyFunds() throws InsufficientFundsException {
        if(user.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient balance for payment.");
        }
    }

    private void deductFunds() {
        user.deductAmount(amount);
    }
}
