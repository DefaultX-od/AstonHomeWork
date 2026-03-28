package ru.aston.task3.chainOfResponsibility;

public abstract class BanknoteDispenser {
    private final int banknoteValue;
    private BanknoteDispenser nextBanknoteDispenser;

    public BanknoteDispenser(final int banknoteValue) {
        this.banknoteValue = banknoteValue;
    }

    public void setNextBanknoteDispenser(final BanknoteDispenser nextBanknoteDispenser) {
        this.nextBanknoteDispenser = nextBanknoteDispenser;
    }

    public void dispense(final int amount) {
        final int count = amount / banknoteValue;
        final int remainder = amount % banknoteValue;

        if (count > 0) {
            write(String.valueOf(count));
        }

        if (nextBanknoteDispenser != null) {
            nextBanknoteDispenser.dispense(remainder);
        } else if (remainder > 0) {
            System.out.printf((Strings.NOT_DISPENSABLE.getStr()) + "%n", remainder);
        }
    }

    public abstract void write(final String message);
}
