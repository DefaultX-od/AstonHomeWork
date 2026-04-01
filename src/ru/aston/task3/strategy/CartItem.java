package ru.aston.task3.strategy;

import java.math.BigDecimal;

public class CartItem {
    private final Game game;

    public CartItem(final Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
