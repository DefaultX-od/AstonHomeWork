package ru.aston.task3.proxy;

import java.util.Scanner;

public class FileReaderDemo {
    public String getUserInput() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");

        return scanner.nextLine();
    }

    public static void main(String[] args) {
        final FileReaderDemo fileReaderDemo = new FileReaderDemo();

        final String filePath = fileReaderDemo.getUserInput();

        final IFileReader fileReader = new ProxyTextFileReader(filePath);
        fileReader.printFile();
    }
}
