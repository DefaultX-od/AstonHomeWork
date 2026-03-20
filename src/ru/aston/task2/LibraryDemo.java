package ru.aston.task2;

import java.util.List;

public class LibraryDemo {

    public static void main(String[] args) {
        final String uri = "src/ru/aston/task2/data.txt";

        final List<Student> students = StudentFileParser.loadStudents(uri);

        LibraryService.printStudentsAndBookYear(students, 2000);
    }
}