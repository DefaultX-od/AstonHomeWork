package ru.aston.task2;

import java.util.List;
import java.util.Scanner;

public class LibraryDemo {

    public static void main(String[] args) {
        final Library library = new Library();

        final String filePathFromUser = library.getFilePathFromUser();

        final List<Student> students = library.getStudentFileParser().loadStudents(filePathFromUser);

        library.getLibraryService().printStudentsAndBookYear(students, 2000);
    }
}