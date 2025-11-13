package com.example.librarymgmt.exceptions;


public abstract class BookException extends BusinessException {
    public BookException(String message) {
        super(message);
    }
}
