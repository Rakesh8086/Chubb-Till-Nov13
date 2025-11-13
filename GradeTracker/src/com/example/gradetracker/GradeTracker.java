package com.example.gradetracker;

import java.util.*;


public class GradeTracker {

    private Map<Integer, Student> students;

    public GradeTracker() {
        this.students = new HashMap<>();
    }


    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Cannot add null student.");
        }
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " already exists.");
        }
        students.put(student.getId(), student);
    }


    public Student getStudentById(int id) throws StudentNotFoundException {
        Student s = students.get(id);
        if (s == null) {
            throw new StudentNotFoundException("No student found with ID: " + id);
        }
        return s;
    }


    public double getAverageForSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }

        int total = 0;
        int count = 0;

        for (Student s : students.values()) {
            Integer mark = s.getMark(subject);
            if (mark != null) {
                total += mark;
                count++;
            }
        }
        
        if (count == 0) {
        	return 0.0;
        }

        return total / (double) count;
    }


    public Map.Entry<String, Integer> getTopperInSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }

        String topperName = null;
        int maxMark = -1;

        for (Student s : students.values()) {
            Integer mark = s.getMark(subject);
            if (mark != null && mark > maxMark) {
                maxMark = mark;
                topperName = s.getName();
            }
        }

        if (topperName == null) return null; 

        return new AbstractMap.SimpleEntry<>(topperName, maxMark);
    }


    public int getStudentCount() {
        return students.size();
    }

    public boolean hasStudents() {
        return !students.isEmpty();
    }
}
