package ru.aston.task2;

import java.util.List;
import java.util.Scanner;

public class LibraryDemo {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final StudentFileParser studentFileParser = new StudentFileParser();
        final LibraryService libraryService = new LibraryService();
        final Library library = new Library(studentFileParser, libraryService, scanner);

        library.operate();
    }
}