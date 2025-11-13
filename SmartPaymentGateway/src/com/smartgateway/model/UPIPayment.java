package com.smartgateway.model;

import com.smartgateway.exception.InvalidPaymentDetailsException;


public class UPIPayment extends Payment {
    private String upiPin;

    public UPIPayment(User user, double amount, String upiPin) {
        super(user, amount);
        this.upiPin = upiPin;
    }

    @Override
    protected void validateDetails() throws InvalidPaymentDetailsException {
        if (!user.validateUpiPin(upiPin)) {
            throw new InvalidPaymentDetailsException("Invalid UPI PIN");
        }
    }
}
