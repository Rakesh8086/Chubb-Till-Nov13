package com.smartgateway.service;

import com.smartgateway.exception.*;
import com.smartgateway.model.*;

public class PaymentService {

    private UserService userService = new UserService();

    public PaymentResult processPayment(User payer, String beneficiaryUsername, Payment payment)
            throws BeneficiaryNotFoundException, InvalidPaymentDetailsException, InsufficientFundsException {

        User beneficiary = userService.findByUsername(beneficiaryUsername);
        if(beneficiary == null) {
            throw new BeneficiaryNotFoundException("Beneficiary user not found!");
        }

        PaymentResult result = payment.processPayment();

        if(result.isSuccess()) {
            beneficiary.addAmount(payment.getAmount());
        }

        return result;
    }
}
