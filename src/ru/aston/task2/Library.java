package ru.aston.task2;

import java.util.Scanner;

public class Library {
    private final StudentFileParser studentFileParser;
    private final LibraryService libraryService;

    public Library() {
        studentFileParser = new StudentFileParser();
        libraryService = new LibraryService();
    }

    public String getFilePathFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        return scanner.nextLine();
    }

    public StudentFileParser getStudentFileParser() {
        return studentFileParser;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }
}
