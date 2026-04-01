package ru.aston.task2;

import java.util.Objects;

public class Book {
    public final static int SIMPLE_FIELDS_NUMBER = 3;

    public static final int NAME_POS = 0;
    public static final int YEAR_POS = 1;
    public static final int PAGE_COUNT_POS = 2;

    private final String name;
    private final int year;
    private final int pageCount;

    public Book(final String name, final int year, final int pageCount) {
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
    public String toString() {
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
