package ru.aston.task3.strategy;

import java.math.BigDecimal;

public class CartService {
    private RegionStrategy regionStrategy;

    public void setRegionStrategy(RegionStrategy regionStrategy) {
        this.regionStrategy = regionStrategy;
    }

    public RegionStrategy getRegionStrategy() {
        return regionStrategy;
    }

    public void addGameToCart(Game game, Cart cart){
        CartItem cartItem = new CartItem(game);
        cart.getCartItems().add(cartItem);
    }

    public BigDecimal calculateCartTotal(Cart cart){
        return cart.getCartItems().stream()
                .map(CartItem::getGame)
                .map(game ->  this.regionStrategy.calculatePrice(game.getPriceUSD()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
