package ru.aston.task2;

import java.util.List;
import java.util.Scanner;

public class LibraryDemo {

    public static String getFilePathFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        final String filePathFromUser = getFilePathFromUser();

        final List<Student> students = StudentFileParser.loadStudents(filePathFromUser);

        LibraryService.printStudentsAndBookYear(students, 2000);
    }
}