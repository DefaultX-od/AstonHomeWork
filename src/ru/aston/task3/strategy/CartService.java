package ru.aston.task3.strategy;

import java.math.BigDecimal;

public class CartService {

    public void addGameToCart(Game game, Cart cart) {
        CartItem cartItem = new CartItem(game);
        cart.getCartItems().add(cartItem);
    }

    public BigDecimal calculateCartTotal(Cart cart) {
        RegionStrategy regionStrategy = cart.getRegionStrategy();

        return cart.getCartItems().stream()
                .map(CartItem::getGame)
                .map(game -> regionStrategy.calculatePrice(game.getPriceUSD()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
