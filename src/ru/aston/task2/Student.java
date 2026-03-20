package ru.aston.task2;

import java.util.List;

public class Student {
    final private int id;
    final private String group;
    final private String firstName;
    final private String lastName;
    final private int course;
    final private List<Book> books;

    public Student(final String[] args, final List<Book> books) {
        this.id = Integer.parseInt(args[0]);
        this.group = args[1];
        this.firstName = args[2];
        this.lastName = args[3];
        this.course = Integer.parseInt(args[4]);
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
        return books;
    }

    @Override
    public String toString() {
        return String.format("{id: %d, group: %s, firstName: %s, lastName: %s, course: %d}", id, group, firstName, lastName, course);
    }
}