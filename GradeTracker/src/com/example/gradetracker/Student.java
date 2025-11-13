package com.example.gradetracker;

import java.util.HashMap;
import java.util.Map;


public class Student {

    private int id;
    private String name;
    private Map<String, Integer> marks;  

    
    public Student(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.id = id;
        this.name = name.trim();
        this.marks = new HashMap<>();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
    }

    public Map<String, Integer> getMarks() {
        return new HashMap<>(marks);
    }

    
    public void setMark(String subject, int mark) throws InvalidMarkException {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        if (mark < 0 || mark > 100) {
            throw new InvalidMarkException("Mark must be between 0 and 100.");
        }
        marks.put(subject.trim(), mark);
    }


    public Integer getMark(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        return marks.get(subject.trim());
    }


    public double getAverage() {
        if (marks.isEmpty()) return 0.0;
        int total = 0;
        for (int score : marks.values()) {
            total += score;
        }
        return total / (double) marks.size();
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
