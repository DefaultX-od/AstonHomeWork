package ru.aston.task1;

import java.util.*;

public final class Book {
    private final String name;
    private final String author;
    private final List<Page> pages;
    private final int pageCount;

    public Book(final String name, final String author, final List<Page> pages) {
        this.name = name;
        this.author = author;
        this.pages = new ArrayList<>();
        Optional.ofNullable(pages)
                .ifPresent(pList -> pList.stream()
                        .filter(Objects::nonNull)
                        .forEach(page -> this.pages.add(page.clone())));
        this.pageCount = this.pages.size();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<Page> getPages() {
        return this.pages.stream()
                .map(Page::clone)
                .toList();
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return String.format("| Название: %s| Автор: %s | Количество страниц %d |", name, author, pageCount);
    }
}
