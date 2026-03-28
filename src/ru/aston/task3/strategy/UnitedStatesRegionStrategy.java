package ru.aston.task3.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnitedStatesRegionStrategy implements RegionStrategy {
    public final static BigDecimal TAX_MULTIPLIER = new BigDecimal("1.1");

    @Override
    public BigDecimal calculatePrice(final BigDecimal priceUSD) {
        return priceUSD.multiply(TAX_MULTIPLIER)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Currency getCurrency() {
        return Currency.USD;
    }
}