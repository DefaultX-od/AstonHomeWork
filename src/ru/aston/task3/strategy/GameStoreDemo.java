package ru.aston.task3.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameStoreDemo {
    public static void main(String[] args) {
        final CartService cartService = new CartService();
        final GameStore gameStore = new GameStore(cartService);

        final Cart cart = new Cart(
                new ArrayList<>(List.of(
                        new CartItem(new Game("Death Stranding", "Some cool game", new BigDecimal("49.99"))),
                        new CartItem(new Game("Death Stranding 2: on the beach", "Some cool game version 2", new BigDecimal("89.99")))
                ))
        );

        gameStore.run(cart, RegionStrategies.RU.getRegionStrategy());
        gameStore.run(cart, RegionStrategies.US.getRegionStrategy());
    }
}
