package ru.aston.task2;

import java.util.List;

public class StudentParserResultHelper {
    private final String[] studentData;
    private final List<String[]> booksData;

    public StudentParserResultHelper(final String[] studentData, final List<String[]> booksData) {
        this.studentData = studentData;
        this.booksData = List.copyOf(booksData);
    }

    public String[] getStudent() {
        return studentData;
    }

    public List<String[]> getBooks() {
        return List.copyOf(booksData);
    }
}