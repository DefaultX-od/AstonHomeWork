package ru.aston.task3.strategy;

import java.util.List;

public class Cart {
    private RegionStrategy regionStrategy;
    private final List<CartItem> cartItems;

    public Cart(final List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setRegionStrategy(final RegionStrategy regionStrategy) {
        this.regionStrategy = regionStrategy;
    }

    public RegionStrategy getRegionStrategy() {
        return regionStrategy;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
