package com.example.librarymgmt;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager library = new LibraryManager();

        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");

        boolean flag = true;

        while (flag) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Remove Member");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBook(scanner, library);
                    break;
                case 2:
                    registerMember(scanner, library);
                    break;
                case 3:
                    borrowBook(scanner, library);
                    break;
                case 4:
                    returnBook(scanner, library);
                    break;
                case 5:
                    removeBook(scanner, library);
                    break;
                case 6:
                    removeMember(scanner, library);
                    break;
                case 7:
                	flag = false;
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

            if (flag) {
                System.out.print("Do you wish to continue? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("no") || response.equals("n")) {
                	flag = false;
                    System.out.println("Exiting");
                }
            }
        }

        scanner.close();
    }

    private static void addBook(Scanner scanner, LibraryManager library) {
        try {
            System.out.print("Enter Book ID (integer): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Book Title: ");
            String title = scanner.nextLine().trim();

            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine().trim();

            System.out.print("Enter Number of Copies: ");
            int copies = Integer.parseInt(scanner.nextLine().trim());

            Book book = new Book(id, title, author, copies);
            library.addBook(book);

            System.out.println("Book added successfully: " + title);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private static void registerMember(Scanner scanner, LibraryManager library) {
        try {
            System.out.print("Enter Member ID (integer): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Member Name: ");
            String name = scanner.nextLine().trim();

            Member member = new Member(id, name);
            library.registerMember(member);

            System.out.println("Member registered successfully: " + name);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error registering member: " + e.getMessage());
        }
    }

    private static void borrowBook(Scanner scanner, LibraryManager library) {
        try {
            System.out.print("Enter Member ID: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Book ID: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());

            library.borrowBook(memberId, bookId);

            System.out.println("Book borrowed successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    private static void returnBook(Scanner scanner, LibraryManager library) {
        try {
            System.out.print("Enter Member ID: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Book ID: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());

            library.returnBook(memberId, bookId);

            System.out.println("Book returned successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }

    private static void removeBook(Scanner scanner, LibraryManager library) {
        try {
            System.out.print("Enter Book ID to remove: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());
            library.removeBook(bookId);
            System.out.println("Book removed successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }

    private static void removeMember(Scanner scanner, LibraryManager library) {
        try {
            System.out.print("Enter Member ID to remove: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            library.removeMember(memberId);
            System.out.println("Member removed successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing member: " + e.getMessage());
        }
    }
}
