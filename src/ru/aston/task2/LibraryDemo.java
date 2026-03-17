package ru.aston.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LibraryDemo {

    public static List<String> loadData(String uri) {
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(Paths.get(uri));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println(e);
        }
        return data;
    }

    public static void main(String[] args) {
        final String uri = "src/ru/aston/task2/data.txt";
        List<String> data = loadData(uri);

        List<Student> students = new ArrayList<>();

        for (String line : data) {
            String[] parts = line.trim().split("\\|");
            if (parts.length < 2) {
                throw new IllegalArgumentException(String.format("Неверный формат данных в строке: '%s'", line));
            }

            String[] studentData = parts[0].trim().split(",");
            if (studentData.length < 5) {
                throw new IllegalArgumentException(String.format("Недостаточно данных в записи: '%s'", parts[0]));
            }

            String[] booksData = parts[1].trim().split("/");
            List<Book> books = new ArrayList<>();

            for (String bd : booksData) {
                if (bd.isEmpty()) {
                    continue;
                }

                String[] bookFields = bd.split(",");
                if (bookFields.length < 3) {
                    throw new IllegalArgumentException(String.format("Недостаточно данных в записи: '%s'", bd));
                }
                books.add(new Book(bookFields));
            }
            students.add(new Student(studentData, books));
        }

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPageCount))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Такая книга отсутсвует")
                );
    }
}