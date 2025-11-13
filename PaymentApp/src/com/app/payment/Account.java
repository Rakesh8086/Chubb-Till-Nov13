package com.app.payment;

import java.util.Objects;

public class Account {
	private String name;
	private String accNo;
	private String country;
	private String ifsc;
	private double balance;
	
	public Account(String name, String accNo, String country, String ifsc, double balance) {
		this.name = name;
		this.accNo = accNo;
		this.country = country;
		this.ifsc = ifsc;
		this.balance = balance;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
    public String toString() {
        return "Account {" +
                "name='" + name + '\'' +
                ", accNo=" + accNo +
                ", country='" + country + '\'' +
                ", ifscCode='" + ifsc + '\'' +
                ", balance=" + balance +
                '}';
    }
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	    	return true;                      // same reference
	    }
	    if (obj == null || getClass() != obj.getClass()) {   // null or different type
	        return false;
	    }
	    Account other = (Account) obj;

	    return name.equals(other.name) && accNo.equals(other.accNo);
	}
	

	
	@Override
	public int hashCode() {
	    return Objects.hash(name, accNo);
	}
}
