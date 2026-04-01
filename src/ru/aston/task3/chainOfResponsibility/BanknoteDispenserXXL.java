package ru.aston.task3.chainOfResponsibility;

public class BanknoteDispenserXXL extends BanknoteDispenser {

    public BanknoteDispenserXXL(final int amount) {
        super(amount);
    }

    @Override
    public void write(final String message) {
        System.out.printf((Strings.DISPENSED.getStr()) + "%n", Banknotes.FIVE_THOUSANDS.getValue(), message);
    }
}
