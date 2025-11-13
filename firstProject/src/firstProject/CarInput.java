package firstProject;
import java.util.*;

public class CarInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cost: ");
		int cost = sc.nextInt();
		System.out.println("Enter payment made: ");
		int paid = sc.nextInt();
		System.out.println("Enter number of years: ");
		int years = sc.nextInt();
		System.out.println("Enter interest: ");
		int interest = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter type of interest: ");
		String type = sc.nextLine();
		
		EmiCalculator e = new EmiCalculator();
		if(type.equals("simple")) {
			System.out.println("Simple Interest is " + 
			e.simpleInterest(years, cost, interest));
			System.out.println("Total amount paid after down payment as EMI is " + 
					e.emi(years, cost-paid, interest) * 12 * years);
		}
		else if(type.equals("compound")){
			System.out.println("Compound Interest is " + 
			e.compoundInterest(years, cost, interest));
			System.out.println("Total amount paid after down payment as EMI is " + 
					e.emi(years, cost-paid, interest) * 12 * years);
		}
					
		sc.close();
	}

}
