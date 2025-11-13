package com.app.dto;

public class Customer {
	
	private double amountbalance;
	private String email;
    private String accountno;
    private String name;
	
	
	public Customer(String custname,String custemail,String accountdetails,double balance){
		this.accountno = accountdetails;
		this.amountbalance = balance;
		this.email = custemail;
		this.name = custname;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAmountbalance() {
		return amountbalance;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAccountno() {
		return accountno;
	}
    
    public void setAmount(double amount) {
    	this.amountbalance = amount;
    }
    
}