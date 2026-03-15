package ru.aston.task2;

public class Book {
    private String name;
    private int year;
    private int pageCount;

    public Book(String[] args){
        this.name = args[0];
        this.year = Integer.parseInt(args[1]);
        this.pageCount = Integer.parseInt(args[2]);
    }

    public String getName(){
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return String.format("{name: %s, year: %d, pageCount: %d}", name, year, pageCount);
    }
}
