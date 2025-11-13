package com.app.payment;

import java.util.Comparator;

public class StringComparator implements Comparator<Accounts> {
	@Override
    public int compare(Accounts a1, Accounts a2) {
        return a2.getName().compareTo(a1.getName());
    }
}
