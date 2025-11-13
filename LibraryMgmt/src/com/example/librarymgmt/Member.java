package com.example.librarymgmt;

import java.util.ArrayList;
import java.util.Collections;


public class Member {

    private int memberId;
    private String name;
    private ArrayList<Integer> borrowedBooks;


    public Member(int memberId, String name) {
        this(memberId, name, "N/A");
    }

    
    public Member(int memberId, String name, String contactInfo) {
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty.");
        }

        this.memberId = memberId;
        this.name = name.trim();
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getBorrowedBooks() {
        return (ArrayList<Integer>) Collections.unmodifiableList(borrowedBooks);
    }

    
    public void borrowBook(int bookId) {
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID must be positive.");
        }
        if (borrowedBooks.contains(bookId)) {
            throw new IllegalStateException("Book ID " + bookId + " already borrowed by this member.");
        }
        borrowedBooks.add(bookId);
    }
    
    public void returnBook(int bookId) {
        if (!borrowedBooks.contains(bookId)) {
            throw new IllegalStateException("Book ID " + bookId + " was not borrowed by this member.");
        }
        borrowedBooks.remove(Integer.valueOf(bookId));
    }

    public boolean hasBorrowed(int bookId) {
        return borrowedBooks.contains(bookId);
    }
}
