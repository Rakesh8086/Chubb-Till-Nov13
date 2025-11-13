package com.app.book;

public class Book {
	private String bookId;
	private String bookName;
	private String author;
	private int totalAvailability;
	private int currentAvailability;
	private double cost;
	
	public Book(String bookId, String bookName, String author, int totalAvailability,
			double cost) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.totalAvailability = totalAvailability;
		this.currentAvailability = totalAvailability;
		this.cost = cost;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getTotalAvailability() {
		return totalAvailability;
	}
	public void setTotalAvailability(int totalAvailability) {
		this.totalAvailability = totalAvailability;
	}
	public int getCurrentAvailability() {
		return currentAvailability;
	}
	public void setCurrentAvailability(int currentAvailability) {
		this.currentAvailability = currentAvailability;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
