package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenser50 extends BanknoteDispenser {

    public BanknoteDispenser50(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.FIFTY.getValue(), message);
    }
}
