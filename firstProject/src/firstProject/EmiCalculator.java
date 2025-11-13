package firstProject;
import java.util.*;
import java.math.*;

public class EmiCalculator {

	public double emi(int years, int principle, double r) {
		// TODO Auto-generated method stub
		int n = years * 12;
		r = r / (12 * 100);
		double amount = (principle * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
		
		return amount;

	}
	
	public double simpleInterest(int years, int principal, double r) {
        double rate = r / 100;
        double amount = principal * (1 + rate * years);
        return amount; 
    }
	
	public double compoundInterest(int years, int principal, double r) { 
	    double rate = r / (100 * 12);
	    
	    return principal * Math.pow(1 + rate, 12 * years);
    }

}
