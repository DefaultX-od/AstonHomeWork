package ru.aston.task3.strategy;

import java.math.BigDecimal;

public class Game {
    private final String name;
    private final String description;
    private final BigDecimal priceUSD;

    public Game(final String name, final String description, final BigDecimal priceUSD){
        this.name = name;
        this.description = description;
        this.priceUSD = priceUSD;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPriceUSD() {
        return priceUSD;
    }
}
