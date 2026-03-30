package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenser1000 extends BanknoteDispenser {

    public BanknoteDispenser1000(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.ONE_THOUSAND.getValue(), message);
    }
}
