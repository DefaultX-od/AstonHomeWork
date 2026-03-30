package ru.aston.task2;

import java.util.List;

public class Student {
    public final static int MIN_NUMBER_OF_BOOKS = 5;
    public final static int SIMPLE_FIELDS_NUMBER = 5;

    private final int id;
    private final String group;
    private final String firstName;
    private final String lastName;
    private final int course;
    private final List<Book> books;

    public Student(Builder builder) {
        this.id = builder.id;
        this.group = builder.group;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.course = builder.course;
        this.books = builder.books;
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

    public static class Builder {
        private int id;
        private String group;
        private String firstName;
        private String lastName;
        private int course;
        private List<Book> books;

        public Builder id(final int id) {
            this.id = id;
            return this;
        }

        public Builder group(final String group) {
            this.group = group;
            return this;
        }

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder course(final int course) {
            this.course = course;
            return this;
        }

        public Builder books(final List<Book> books) {
            this.books = List.copyOf(books);
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}