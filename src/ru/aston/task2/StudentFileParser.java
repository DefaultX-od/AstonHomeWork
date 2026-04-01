package ru.aston.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentFileParser {
    public static final int MIN_NUMBER_OF_PARTS = 2;

    public List<String> loadData(final String filePathFromUser) {
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(Paths.get(filePathFromUser));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println(e);
        }

        return data;
    }

    private String[] separateStudentsFromBooks(final String line) throws IllegalArgumentException {
        final String[] parts = line.trim().split("\\|");

        if (parts.length < MIN_NUMBER_OF_PARTS) {
            throw new IllegalArgumentException(String.format("Неверный формат данных в строке: '%s'", line));
        }

        return parts;
    }

    private String[] separateStudentFields(final String studentString) throws IllegalArgumentException {
        final String[] studentData = studentString.trim().split(",");

        if (studentData.length < Student.SIMPLE_FIELDS_NUMBER) {
            throw new IllegalArgumentException(String.format("Недостаточно данных в записи о студенте: '%s'", studentString));
        }

        return studentData;
    }

    private String[] separateBooks(final String booksString) throws IllegalArgumentException {
        final String[] booksArr = booksString.trim().split("/");

        if (booksArr.length < Student.MIN_NUMBER_OF_BOOKS) {
            throw new IllegalArgumentException("У студента должно быть не менее 5 книг");
        }

        return booksArr;
    }

    private List<String> separateBookFields(final String bookString) throws IllegalArgumentException {
        final List<String> bookFields = Arrays.asList(bookString.trim().split(","));

        if (bookFields.size() < Book.SIMPLE_FIELDS_NUMBER) {
            throw new IllegalArgumentException(String.format("Недостаточно данных в записи о книге: '%s'", bookString));
        }

        return bookFields;
    }

    private StudentParserResultHelper parseLine(final String line) {
        final String[] parts = separateStudentsFromBooks(line);

        final String[] studentData = separateStudentFields(parts[0]);

        final List<String> booksStringList = Arrays.stream(separateBooks(parts[1])).toList();

        final List<String[]> booksList = booksStringList.stream()
                .map(this::separateBookFields)
                .map(book -> book.toArray(new String[0]))
                .collect(Collectors.toList());

        return new StudentParserResultHelper(studentData, booksList);
    }

    public List<Student> loadStudents(final String filePathFromUser) {
        List<String> data = loadData(filePathFromUser);

        return data.stream()
                .map(this::parseLine)
                .map(studentParserResultHelper -> {
                    final String[] studentData = studentParserResultHelper.getStudent();
                    final int studentId = Integer.parseInt(studentData[Student.ID_POS]);
                    final String studentGroup = studentData[Student.GROUP_POS];
                    final String studentFirstName = studentData[Student.FIRST_NAME_POS];
                    final String studentLastName = studentData[Student.LAST_NAME_POS];
                    final int studentCourse = Integer.parseInt(studentData[Student.COURSE_POS]);

                    final List<Book> books = studentParserResultHelper.getBooks().stream()
                            .map(bookData -> {
                                final String name = bookData[Book.NAME_POS];
                                final int year = Integer.parseInt(bookData[Book.YEAR_POS]);
                                final int pageCount = Integer.parseInt(bookData[Book.PAGE_COUNT_POS]);
                                return new Book(name, year, pageCount);
                            })
                            .toList();

                    return Student.builder().id(studentId).group(studentGroup).firstName(studentFirstName).lastName(studentLastName).course(studentCourse).books(books).build();
                })
                .collect(Collectors.toList());
    }
}