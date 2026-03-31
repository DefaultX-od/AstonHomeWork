package ru.aston.task3.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameStoreDemo {
    public static void main(String[] args) {
        final Map<String, IRegionStrategy> regionStrategyMap = Map.of(
                "RU", new RussianIRegionStrategy(),
                "US", new UnitedStatesIRegionStrategy()
        );

        final RegionStrategyRegistry regionStrategyRegistry = new RegionStrategyRegistry(regionStrategyMap);
        final CartService cartService = new CartService(regionStrategyRegistry);
        final GameStore gameStore = new GameStore(cartService);

        final Cart cart = new Cart(
                new ArrayList<>(List.of(
                        new CartItem(new Game("Death Stranding", "Some cool game", new BigDecimal("49.99"))),
                        new CartItem(new Game("Death Stranding 2: on the beach", "Some cool game version 2", new BigDecimal("89.99")))
                ))
        );

        gameStore.run(cart, "RU");
        gameStore.run(cart, "US");
    }
}
