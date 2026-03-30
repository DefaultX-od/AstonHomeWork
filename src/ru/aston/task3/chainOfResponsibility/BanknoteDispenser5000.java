package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenser5000 extends BanknoteDispenser {

    public BanknoteDispenser5000(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.FIVE_THOUSANDS.getValue(), message);
    }
}
