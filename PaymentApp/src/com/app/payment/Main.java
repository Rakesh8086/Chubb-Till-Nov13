package com.app.payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*Set<Account> accounts = new HashSet<>();

        accounts.add(new Account("AAA", "101", "USA", "111", 5000.00));
        accounts.add(new Account("BBB", "102", "UK", "112", 12000.00));
        accounts.add(new Account("CCC", "103", "India", "113", 7500.00));
        accounts.add(new Account("DDD", "104", "Canada", "114", 9500.00));
        accounts.add(new Account("AAA", "101", "USA", "IFSC001", 5000.75));
        
        List<Account> sortedList = new ArrayList<>(accounts);

        // Collections.sort(sortedList, new BalanceComparator());
        Collections.sort(sortedList, new AccountNoComparator());


        for (Account acc : sortedList) {
            System.out.println(acc);
        }
        */
    	
    	String filePath = "C:/Users/metal/OneDrive/Desktop/accounts.txt"; 
    	AccountFileReader.processTransactions(filePath);
    }
}
