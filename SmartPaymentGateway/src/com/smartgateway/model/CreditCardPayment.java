package com.smartgateway.model;

import com.smartgateway.exception.InvalidPaymentDetailsException;

public class CreditCardPayment extends Payment {
    private String cardPin;

    public CreditCardPayment(User user, double amount, String cardPin) {
        super(user, amount);
        this.cardPin = cardPin;
    }

    @Override
    protected void validateDetails() throws InvalidPaymentDetailsException {
        if (!user.validateCardPin(cardPin)) {
            throw new InvalidPaymentDetailsException("Invalid Card PIN");
        }
    }
}
