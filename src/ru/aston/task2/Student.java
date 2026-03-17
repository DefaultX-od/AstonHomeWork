package ru.aston.task2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Student {
    private int id;
    private String group;
    private String firstName;
    private String lastName;
    private int course;
    private List<Book> books;

    public Student(String[] args, List<Book> books) {
        this.id = Integer.parseInt(args[0]);
        this.group = (args[1] == null) ? "" : args[1];
        this.firstName = (args[2] == null) ? "" : args[2];
        this.lastName = (args[3] == null) ? "" : args[3];
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

    public void setId(int id) {
        this.id = id;
    }

    public void setGroup(String group) {
        this.group = (group == null) ? "" : group;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName == null) ? "" : firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName == null) ? "" : lastName;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setBooks(List<Book> books) {
        this.books = (books == null) ? List.of() : List.copyOf(books);
    }

    @Override
    public String toString() {
        return String.format("{id: %d, group: %s, firstName: %s, lastName: %s, course: %d}", id, group, firstName, lastName, course);
    }
}