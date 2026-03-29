package ru.aston.task3.proxy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class TextFileReader implements IFileReader {
    private final String filePath;
    final private List<String> fileContent;

    public TextFileReader(String filePath) {
        this.filePath = filePath;
        this.fileContent = loadFile();
    }

    public List<String> loadFile() {
        System.out.printf("Загружаю файл: %s...%n", filePath);

        List<String> content = Collections.emptyList();

        try {
            content = Files.readAllLines(Paths.get(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content;
    }

    @Override
    public void printFile() {
        System.out.println("Содержимое файла:");
        fileContent.forEach(System.out::println);
    }
}
