package com.example.librarymgmt.exceptions;


public class BookNotAvailableException extends BookException {
    public BookNotAvailableException(String title) {
        super("Book '" + title + "' is currently not available for borrowing.");
    }
}
