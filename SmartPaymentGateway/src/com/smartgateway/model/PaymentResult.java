package com.smartgateway.model;


public class PaymentResult {
    private boolean success;
    private String message;
    private double chargedAmount;

    public PaymentResult(boolean success, String message, double chargedAmount) {
        this.success = success;
        this.message = message;
        this.chargedAmount = chargedAmount;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public double getChargedAmount() {
        return chargedAmount;
    }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", chargedAmount=" + chargedAmount +
                '}';
    }
}
