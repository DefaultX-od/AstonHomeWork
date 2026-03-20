package ru.aston.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentFileParser {
    final public static int MIN_NUMBER_OF_PARTS = 2;

    private StudentFileParser(){

    }

    public static List<String> loadData(final String uri) {
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

    private static String[] separateStudentsFromBooks(final String line) throws IllegalArgumentException {
        final String[] parts = line.trim().split("\\|");

        if (parts.length < MIN_NUMBER_OF_PARTS){
            throw new IllegalArgumentException(String.format("Неверный формат данных в строке: '%s'", line));
        }

        return parts;
    }

    private static String[] separateStudentFields(final String studentString) throws IllegalArgumentException {
        final String[] studentData = studentString.trim().split(",");

        if (studentData.length < Student.SIMPLE_FIELDS_NUMBER){
            throw new IllegalArgumentException(String.format("Недостаточно данных в записи о студенте: '%s'", studentString));
        }

        return studentData;
    }

    private static String[] separateBooks(final String booksString) throws IllegalArgumentException {
        final String[] booksArr = booksString.trim().split("/");

        if (booksArr.length < Student.MIN_NUMBER_OF_BOOKS){
            throw new IllegalArgumentException("У студента должно быть не менее 5 книг");
        }

        return booksArr;
    }

    private static List<String> separateBookFields(final String bookString) throws IllegalArgumentException {
        final List<String> bookFields = Arrays.asList(bookString.trim().split(","));

        if (bookFields.size() < Book.SIMPLE_FIELDS_NUMBER){
            throw new IllegalArgumentException(String.format("Недостаточно данных в записи о книге: '%s'", bookString));
        }

        return bookFields;
    }

    private static StudentParserResultHelper parseLine(final String line) {
        final String[] parts = separateStudentsFromBooks(line);

        final String[] studentData = separateStudentFields(parts[0]);

        final List<String> booksStringList =  Arrays.stream(separateBooks(parts[1])).toList();
        List<String[]> booksList = new ArrayList<>();

        for (final String bookString : booksStringList){
            List<String> fields = separateBookFields(bookString);
            booksList.add(fields.toArray(new String[0]));
        }

        return new StudentParserResultHelper(studentData, booksList);
    }

    public static List<Student> loadStudents(final String uri){
        List<String> data = StudentFileParser.loadData(uri);
        List<Student> students = new ArrayList<>();

        for (final String line : data){
            final List<Book> books = new ArrayList<>();
            final StudentParserResultHelper studentParserResultHelper = parseLine(line);

            final String[] studentData = studentParserResultHelper.getStudent();
            final int studentId = Integer.parseInt(studentData[0]);
            final String studentGroup = studentData[1];
            final String studentFirstName = studentData[2];
            final String studentLastName = studentData[3];
            final int studentCourse = Integer.parseInt(studentData[4]);

            for (final String[] bookData : studentParserResultHelper.getBooks()){
                final String name = bookData[0];
                final int year = Integer.parseInt(bookData[1]);
                final int pageCount = Integer.parseInt(bookData[2]);

                books.add(new Book(name, year, pageCount));
            }

            students.add(new Student(studentId, studentGroup, studentFirstName, studentLastName, studentCourse, books));
        }

        return students;
    }
}
