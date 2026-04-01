package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenserM extends BanknoteDispenser {

    public BanknoteDispenserM(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.FIVE_HUNDRED.getValue(), message);
    }
}
