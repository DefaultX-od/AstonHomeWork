package ru.aston.task3.proxy;

public class ProxyTextFileReader implements IFileReader {
    private final String filePath;
    private TextFileReader textFileReader;

    public ProxyTextFileReader(final String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void printFile() {
        if (textFileReader == null) {
            textFileReader = new TextFileReader(filePath);
        }

        textFileReader.printFile();
    }
}
