package com.example.librarymgmt;

import java.util.HashMap;
import java.util.Map;

import com.example.librarymgmt.exceptions.BookNotAvailableException;
import com.example.librarymgmt.exceptions.BookNotFoundException;

public class LibraryManager {
	Map<Integer, Book> books;
	Map<Integer, Member> members;
	
	public LibraryManager() {
		this.books = new HashMap<>();
		this.members = new HashMap<>();
	}
	
	public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Cannot add a null book.");
        }
        if (books.containsKey(book.getId())) {
            throw new IllegalArgumentException("Book with ID " + book.getId() + " already exists.");
        }
        books.put(book.getId(), book);
    }

    public void registerMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (members.containsKey(member.getMemberId())) {
            throw new IllegalArgumentException("Member with ID " + member.getMemberId() + " already exists.");
        }
        members.put(member.getMemberId(), member);
    }
	
    public void borrowBook(int memberId, int bookId) {
        Member member = members.get(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member with ID " + memberId + " not found.");
        }

        if (!books.containsKey(bookId)) {
            throw new BookNotFoundException(bookId);
        }
        
        Book book = books.get(bookId);
        if (!book.isAvailable()) {
        	throw new BookNotAvailableException(book.getTitle());
        }

        if (member.hasBorrowed(bookId)) {
            throw new IllegalStateException("Member has already borrowed this book.");
        }

        book.borrowCopy();
        member.borrowBook(bookId);
    }
    
    public void returnBook(int memberId, int bookId) {
        Member member = members.get(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member with ID " + memberId + " not found.");
        }

        Book book = books.get(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book with ID " + bookId + " not found.");
        }

        if (!member.hasBorrowed(bookId)) {
            throw new IllegalStateException("This member did not borrow this book.");
        }

        book.returnCopy();
        member.returnBook(bookId);
    }
    
    public void removeBook(int bookId) {
        if (!books.containsKey(bookId)) {
            throw new IllegalArgumentException("Book with ID " + bookId + " does not exist.");
        }
        books.remove(bookId);
    }

    public void removeMember(int memberId) {
        if (!members.containsKey(memberId)) {
            throw new IllegalArgumentException("Member with ID " + memberId + " does not exist.");
        }
        members.remove(memberId);
    }
}
