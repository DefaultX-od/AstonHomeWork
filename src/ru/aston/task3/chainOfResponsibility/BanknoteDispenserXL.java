package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenserXL extends BanknoteDispenser {

    public BanknoteDispenserXL(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.TWO_THOUSANDS.getValue(), message);
    }
}