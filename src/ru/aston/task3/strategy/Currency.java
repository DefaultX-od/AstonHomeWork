package ru.aston.task3.strategy;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Currency {
    USD(new BigDecimal("1.00")),
    RUB(new BigDecimal("90.00"));

    private final BigDecimal rate;

    Currency(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal convertTo(BigDecimal amount, Currency currency) {
        return amount.divide(this.rate, MathContext.DECIMAL128)
                .multiply(currency.getRate());
    }
}
