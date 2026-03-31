package ru.aston.task3.strategy;

import java.math.BigDecimal;

public class CartService {
    private final RegionStrategyRegistry regionStrategyRegistry;

    public CartService(final RegionStrategyRegistry regionStrategyRegistry) {
        this.regionStrategyRegistry = regionStrategyRegistry;
    }

    public BigDecimal calculateCartTotal(final Cart cart, final IRegionStrategy regionStrategy) {
        return cart.getCartItems().stream()
                .map(CartItem::getGame)
                .map(game -> regionStrategy.calculatePrice(game.getPriceUSD()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public RegionStrategyRegistry getRegionStrategyRegistry() {
        return regionStrategyRegistry;
    }
}
