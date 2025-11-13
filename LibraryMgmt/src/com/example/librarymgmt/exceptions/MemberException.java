package com.example.librarymgmt.exceptions;


public abstract class MemberException extends BusinessException {
    public MemberException(int memberId) {
    	super("Member with ID " + memberId + " does not exist.");
    }
}
