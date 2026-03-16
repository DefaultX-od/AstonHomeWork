package ru.aston.task1;

import java.util.List;

public class BookDemo {
    public static void main(String[] args) {
        List<Page> pages = List.of(
                new Page(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
                new Page(2, "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
                new Page(3, "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.")
        );
        Book book = new Book("Lorem ipsum", "Marcus Tullius Cicero", pages);
        System.out.println(book);
        System.out.println("Содержание книги:");
        for(Page page: book.getPages()){
            System.out.println(page);
        }

    }
}