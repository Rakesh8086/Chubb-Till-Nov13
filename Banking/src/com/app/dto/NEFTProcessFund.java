package com.app.dto;

import com.app.process.SMSProcessing;

import app.ProcessPayment;

public  class NEFTProcessFund extends ProcessPayment implements SMSProcessing {

	public void processFund(Customer intiator,Customer bene,double amount) throws AccountBalanceException {
		// TODO Auto-generated method stub

		 System.out.println("Hi this is first program in NEFTProcessFund");
		 
		 if(intiator!=null && bene!=null)
		 {
			if(intiator.getAmountbalance()>amount && amount>20000)
			{
				double balanceamount = intiator.getAmountbalance() - amount;
				intiator.setAmount(balanceamount);
				bene.setAmount(bene.getAmountbalance()+amount);
				System.out.println("process fund imediately");
			}
			else {
				throw new AccountBalanceException("not having sufficient balance or not a NEFT payment");
				
			}
		 }
	}

	public  boolean validateCustomer(Customer c1) {
		
		if(c1.getName()!=null && !c1.getName().equals("Bin Laden")) 
		{
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean validateEmail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendSMS(Customer c1) {
		// TODO Auto-generated method stub
		
		System.out.println("sent sms to customer "+c1.getName());
		return true;
	}
	
}