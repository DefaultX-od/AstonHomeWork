package ru.aston.task3.strategy;

import java.math.BigDecimal;

public interface IRegionStrategy {
    BigDecimal calculatePrice(final BigDecimal priceUSD);

    Currency getCurrency();
}