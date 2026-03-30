package ru.aston.task1;

import java.util.Objects;

public class Page implements Cloneable {
    private int id;
    private int wordCount;
    private String content;

    public Page(final int id, final String content) {
        this.id = id;
        this.content = content;
        this.wordCount = this.countWords();
    }

    protected Page(final int id, final int wordCount, final String content) {
        this.id = id;
        this.content = content;
        this.wordCount = wordCount;
    }

    public int countWords() {
        if (this.content.isEmpty()) {
            return 0;
        }

        return this.content.split(" ").length;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setContent(final String content) {
        this.content = content;
        this.wordCount = this.countWords();
    }

    public int getId() {
        return id;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return String.format("| Страница: %d | Количество слов: %d | Содержание: %s |", id, wordCount, content);
    }

    @Override
    public Page clone() {
        try {
            return (Page) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
