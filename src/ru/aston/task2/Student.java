package ru.aston.task2;

import java.util.List;

public class Student {
    final public static int MIN_NUMBER_OF_BOOKS = 5;
    final public static int SIMPLE_FIELDS_NUMBER = 5;

    final private int id;
    final private String group;
    final private String firstName;
    final private String lastName;
    final private int course;
    final private List<Book> books;

    public Student(final int id, final String group, final String firstName, final String lastName, final int course, final List<Book> books) {
        this.id = id;
        this.group = group;
        this.firstName = firstName;
        this.lastName = firstName;
        this.course = course;
        this.books = (books == null) ? List.of() : List.copyOf(books);
    }

    public int getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCourse() {
        return course;
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    @Override
    public String toString() {
        return String.format("{id: %d, group: %s, firstName: %s, lastName: %s, course: %d}", id, group, firstName, lastName, course);
    }
}