package com.example.gradetracker;

import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        System.out.println("=== STUDENT GRADE TRACKER ===");
        boolean flag = true;

        while (flag) {
            System.out.println("Choose an option:");
            System.out.println("1. Add new student");
            System.out.println("2. Add or Update marks for a student");
            System.out.println("3. View average in a subject");
            System.out.println("4. View topper in a subject");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(scanner, tracker);
                    break;
                case 2:
                    addOrUpdateMarks(scanner, tracker);
                    break;
                case 3:
                    showSubjectAverage(scanner, tracker);
                    break;
                case 4:
                    showTopper(scanner, tracker);
                    break;
                case 5:
                    flag = false;
                    System.out.println("App Closed");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (flag) {
                System.out.print("Do you wish to continue? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("no") || response.equals("n")) {
                	flag = false;
                    System.out.println("Program Over");
                }
            }
        }

        scanner.close();
    }


    private static void addStudent(Scanner scanner, GradeTracker tracker) {
        try {
            System.out.print("Enter student ID (integer): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();

            Student student = new Student(id, name);
            tracker.addStudent(student);

            System.out.println("Student added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private static void addOrUpdateMarks(Scanner scanner, GradeTracker tracker) {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Student s = tracker.getStudentById(id);

            System.out.print("Enter subject name: ");
            String subject = scanner.nextLine().trim();

            System.out.print("Enter mark (0–100): ");
            int mark = Integer.parseInt(scanner.nextLine().trim());

            s.setMark(subject, mark);
            System.out.println("Mark updated successfully for " + s.getName() + ".");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMarkException e) {
            System.out.println("Invalid mark: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showSubjectAverage(Scanner scanner, GradeTracker tracker) {
        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine().trim();

        try {
            double avg = tracker.getAverageForSubject(subject);
            if (avg == 0.0) {
                System.out.println("No marks recorded for this subject yet.");
            } else {
                System.out.printf("Average mark in %s: %.2f%n", subject, avg);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showTopper(Scanner scanner, GradeTracker tracker) {
        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine().trim();

        try {
            Map.Entry<String, Integer> topper = tracker.getTopperInSubject(subject);
            if (topper == null) {
                System.out.println("No marks found for this subject.");
            } else {
                System.out.printf("Topper in %s: %s with %d marks%n",
                        subject, topper.getKey(), topper.getValue());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
