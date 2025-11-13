package com.app;

public class SmartCalculator {

	private final CalculatorService calculatorService;

    public SmartCalculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int performAddition(int a, int b) {
        return calculatorService.add(a, b);
    }
}