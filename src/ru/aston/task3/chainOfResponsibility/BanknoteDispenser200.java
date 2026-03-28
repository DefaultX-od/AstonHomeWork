package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenser200 extends BanknoteDispenser {

    public BanknoteDispenser200(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.TWO_HUNDRED.getValue(), message);
    }
}
