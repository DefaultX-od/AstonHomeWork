package ru.aston.task3.strategy;

import java.util.List;

public class Cart {
    private final List<CartItem> cartItems;

    public Cart(final List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
