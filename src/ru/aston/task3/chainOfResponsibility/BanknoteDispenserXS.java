package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenserXS extends BanknoteDispenser {

    public BanknoteDispenserXS(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.ONE_HUNDRED.getValue(), message);
    }
}
