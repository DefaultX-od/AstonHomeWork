package ru.aston.task3.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RussianRegionStrategy implements RegionStrategy {
    public final static BigDecimal REGIONAL_DISCOUNT = new BigDecimal("0.7");

    @Override
    public BigDecimal calculatePrice(final BigDecimal priceUSD) {
        BigDecimal convertedPrice = Currency.USD.convertTo(priceUSD, Currency.RUB);
        return convertedPrice.multiply(REGIONAL_DISCOUNT)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Currency getCurrency() {
        return Currency.RUB;
    }
}
