package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenserS extends BanknoteDispenser {

    public BanknoteDispenserS(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.TWO_HUNDRED.getValue(), message);
    }
}
