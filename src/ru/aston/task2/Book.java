package ru.aston.task2;

import java.util.Objects;

public class Book {
    private String name;
    private int year;
    private int pageCount;

    public Book(final String[] args) {
        this.name = args[0];
        this.year = Integer.parseInt(args[1]);
        this.pageCount = Integer.parseInt(args[2]);
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

    public void setName(final String name) {
        this.name = name;
    }

    public void setPageCount(final int pageCount) {
        this.pageCount = pageCount;
    }

    public void setYear(final int year) {
        this.year = year;
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
