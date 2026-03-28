package ru.aston.task3.chainOfResponsibility;

public enum Banknotes {
    FIVE_THOUSANDS(5000),
    TWO_THOUSANDS(2000),
    ONE_THOUSAND(1000),
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    ONE_HUNDRED(100),
    FIFTY(50);

    private final int value;

    Banknotes(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
