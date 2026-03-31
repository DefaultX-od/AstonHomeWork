package ru.aston.task2;

import java.util.List;
import java.util.Scanner;

public class Library {
    private final StudentFileParser studentFileParser;
    private final LibraryService libraryService;
    private final Scanner scanner;

    public Library(final StudentFileParser parser, final LibraryService service, final Scanner scanner ) {
        studentFileParser = parser;
        libraryService = service;
        this.scanner = scanner;
    }

    public String getFilePathFromUser() {
        System.out.println("Введите путь к файлу:");
        return scanner.nextLine();
    }

    public StudentFileParser getStudentFileParser() {
        return studentFileParser;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }

    public void operate() {
        final String filePathFromUser = getFilePathFromUser();

        final List<Student> students = getStudentFileParser().loadStudents(filePathFromUser);

        getLibraryService().printStudentsAndBookYear(students, 2000);
    }
}
