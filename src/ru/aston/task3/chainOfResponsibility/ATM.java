package ru.aston.task3.chainOfResponsibility;

public class ATM {
    private final BanknoteDispenser initialDispenser;

    public ATM() {
        final BanknoteDispenser banknoteDispenser5000 = new BanknoteDispenser5000(Banknotes.FIVE_THOUSANDS.getValue());
        final BanknoteDispenser banknoteDispenser2000 = new BanknoteDispenser2000(Banknotes.TWO_THOUSANDS.getValue());
        final BanknoteDispenser banknoteDispenser1000 = new BanknoteDispenser1000(Banknotes.ONE_THOUSAND.getValue());
        final BanknoteDispenser banknoteDispenser500 = new BanknoteDispenser500(Banknotes.FIVE_HUNDRED.getValue());
        final BanknoteDispenser banknoteDispenser200 = new BanknoteDispenser200(Banknotes.TWO_HUNDRED.getValue());
        final BanknoteDispenser banknoteDispenser100 = new BanknoteDispenser100(Banknotes.ONE_HUNDRED.getValue());
        final BanknoteDispenser banknoteDispenser50 = new BanknoteDispenser50(Banknotes.FIFTY.getValue());

        banknoteDispenser5000.setNextBanknoteDispenser(banknoteDispenser2000);
        banknoteDispenser2000.setNextBanknoteDispenser(banknoteDispenser1000);
        banknoteDispenser1000.setNextBanknoteDispenser(banknoteDispenser500);
        banknoteDispenser500.setNextBanknoteDispenser(banknoteDispenser200);
        banknoteDispenser200.setNextBanknoteDispenser(banknoteDispenser100);
        banknoteDispenser100.setNextBanknoteDispenser(banknoteDispenser50);

        this.initialDispenser = banknoteDispenser5000;
    }

    public void withdraw(final int amount) {
        initialDispenser.dispense(amount);
    }
}
