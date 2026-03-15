package ru.aston.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Book {
    private final String name;
    private final String author;
    private final List<Page> pages;
    private final int pageCount;

    public Book(String name, String author, List<Page> pages){
        this.name = name;
        this.author = author;
        this.pages = new ArrayList<>();

        for (Page page: pages){
            this.pages.add(new Page(page.id, page.wordCount, page.content));
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
            pagesCopy.add(new Page(page.id, page.wordCount, page.content));
        }
        return Collections.unmodifiableList(pagesCopy);
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString(){
        return String.format("| Название: %s| Автор: %s | Количество страниц %d |",this.name, this.author, this.pageCount);
    }
}
