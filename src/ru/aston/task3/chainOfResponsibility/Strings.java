package ru.aston.task3.chainOfResponsibility;

public enum Strings {
    DISPENSED("%d выдано: %s"),
    NOT_DISPENSABLE("Не удалось выдать: %d"),
    INPUT_AMOUNT_MESSAGE("Введите количество денег:");

    private final String str;

    Strings(final String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
