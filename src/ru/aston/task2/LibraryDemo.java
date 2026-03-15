package ru.aston.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LibraryDemo {

    public static List<String> loadData(String uri){
        List<String> data = new ArrayList<>();
        try{
            data = List.of(Files.readAllLines(Paths.get(uri)).toArray(new String[0]));
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
        catch (IOException e){
            System.out.println(e);
        }
        return data;
    }

    public static void main(String[] args) {
        String URI = "src/ru/aston/task2/data.txt";
        List<String> data = loadData(URI);

        List<Student> students = new ArrayList<>();

        for(String line: data){
            String[] parts = line.split("\\|");
            String[] studentData = parts[0].split(",");
            String[] booksData = parts[1].split("/");
            List<Book> books = new ArrayList<>();

            for(String bd: booksData){
                String[] bookFields = bd.split(",");
                books.add(new Book(bookFields));
            }
            students.add(new Student(studentData, books));
        }

            students.stream().peek(System.out::println)
                    .map(Student::getBooks)
                    .flatMap(List::stream)
                    .sorted(Comparator.comparingInt(Book::getPageCount))
                    .distinct()
                    .filter(it -> it.getYear() > 2000)
                    .limit(3)
                    .map(Book::getYear)
                    .findFirst()
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Такая книга отсутсвует")
                    );


    }
}

