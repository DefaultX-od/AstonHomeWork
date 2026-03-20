package ru.aston.task2;

import java.util.Comparator;
import java.util.List;

public class LibraryService {
    private LibraryService(){

    }

    public static void printStudentsAndBookYear(final List<Student> students, final int minBookYear) {
        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPageCount))
                .distinct()
                .filter(book -> book.getYear() > minBookYear)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Такая книга отсутсвует")
                );
    }
}
