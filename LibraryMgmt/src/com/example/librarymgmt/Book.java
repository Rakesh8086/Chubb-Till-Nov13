package com.example.librarymgmt;

public class Book {
	private int id;
	private String title;
	private String author;
	private int totalCopies;
	private int availableCopies;
	
	public Book(int id, String title, String author, int copies) {
		if (id <= 0) {
            throw new IllegalArgumentException("Book ID must be positive.");
        }
		if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty.");
        }
		if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty.");
        }
		if (copies < 0) {
			throw new IllegalArgumentException("Copies count must be positive.");
		}
		this.id = id;
		this.title = title.trim();
		this.author = author.trim();
		this.totalCopies = copies;
		this.availableCopies = copies;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void borrowCopy() {
		if (availableCopies <= 0) {
            throw new IllegalStateException("No copies of " + title + " are currently available.");
        }
		availableCopies--;
	}
	
	public void returnCopy() {
		availableCopies++;
	}
	
	public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

	public int getId() {
		return id;
	}
	
	public boolean isAvailable() {
        return availableCopies > 0;
    }
}
