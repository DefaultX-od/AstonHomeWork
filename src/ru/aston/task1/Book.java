package ru.aston.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Book {
    private final String name;
    private final String author;
    private final List<Page> pages;
    private final int pageCount;

    public Book(String name, String author, List<Page> pages) {
        this.name = (name == null) ? "" : name;
        this.author = (author == null) ? "" : author;
        this.pages = new ArrayList<>();

        if(pages != null) {
            for (Page page : pages) {
                if(page != null) this.pages.add(page.clone());
            }
        }
        this.pageCount = this.pages.size();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<Page> getPages() {
        List<Page> pagesCopy = new ArrayList<>();
        for (Page page: this.pages){
            pagesCopy.add(page.clone());
        }
        return List.copyOf(pagesCopy);
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return String.format("| Название: %s| Автор: %s | Количество страниц %d |", name, author, pageCount);
    }
}
