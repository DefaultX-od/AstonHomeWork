package ru.aston.task3.strategy;

import java.math.BigDecimal;

public class CartItem {
    private RegionStrategy regionStrategy;
    private final Game game;

    public CartItem(final RegionStrategy regionStrategy, final Game game){
        this.regionStrategy = regionStrategy;
        this.game = game;
    }

    public void setRegionStrategy(RegionStrategy regionStrategy) {
        this.regionStrategy = regionStrategy;
    }

    public RegionStrategy getRegionStrategy() {
        return regionStrategy;
    }

    public BigDecimal getRegionalPrice(){
        return this.regionStrategy.calculatePrice(this.game.getPriceUSD());
    }

    public Game getGame() {
        return game;
    }
}

