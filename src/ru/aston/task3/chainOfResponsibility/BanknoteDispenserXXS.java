package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenserXXS extends BanknoteDispenser {

    public BanknoteDispenserXXS(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.FIFTY.getValue(), message);
    }
}
