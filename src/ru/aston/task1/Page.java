package ru.aston.task1;

public class Page {
    int id;
    int wordCount;
    String content;

    public Page(int id, String content){
        this.id = id;
        this.content = content;
        this.wordCount = this.countWords();
    }

    protected Page(int id, int wordCount, String content){
        this.id = id;
        this.content = content;
        this.wordCount = wordCount;
    }

    public int countWords(){
        if(this.content.isEmpty()){
            return 0;
        }else{
            return this.content.split(" ").length;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
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
    public String toString(){
        return String.format("| Страница: %d | Количество слов: %d | Содержание: %s |", this.id, this.wordCount, this.content);
    }
}
