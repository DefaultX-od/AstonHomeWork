package ru.aston.task2;

import java.util.Objects;

public class Book {
    final public static int SIMPLE_FIELDS_NUMBER = 3;

    final private String name;
    final private int year;
    final private int pageCount;

    public Book(final String name, final int year, final int pageCount ) {
        this.name = name;
        this.year = year;
        this.pageCount = pageCount;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString(){
        return String.format("{name: %s, year: %d, pageCount: %d}", name, year, pageCount);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && pageCount == book.pageCount && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, pageCount);
    }
}
