package com.app.payment;

import java.util.Comparator;

public class AccountNoComparator implements Comparator<Account> {
	@Override
    public int compare(Account a1, Account a2) {
        if(a1.getAccNo().compareTo(a2.getAccNo()) > 0) {
        	return 1;
        }
        else if(a1.getAccNo().compareTo(a2.getAccNo()) < 0) {
        	return -1;
        }
        
        return 0;
    }
}
