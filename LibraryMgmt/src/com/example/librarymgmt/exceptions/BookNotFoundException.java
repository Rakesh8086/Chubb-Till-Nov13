package com.example.librarymgmt.exceptions;


public class BookNotFoundException extends BookException {
    public BookNotFoundException(int bookId) {
        super("Book with ID " + bookId + " does not exist in the library.");
    }
}
