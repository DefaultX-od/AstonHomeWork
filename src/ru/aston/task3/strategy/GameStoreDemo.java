package ru.aston.task3.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GameStoreDemo {
    public final static RussianRegionStrategy RUSSIAN_REGION_STRATEGY = new RussianRegionStrategy();
    public final static UnitedStatesRegionStrategy UNITED_STATES_REGION_STRATEGY = new UnitedStatesRegionStrategy();
    public final static CartService CART_SERVICE = new CartService();

    public static void main(String[] args) {
        final Cart userCart = new Cart(
                new ArrayList<>(List.of(
                        new CartItem(new Game("Death Stranding", "Some cool game", new BigDecimal("49.99"))),
                        new CartItem(new Game("Death Stranding 2: on the beach", "Some cool game version 2", new BigDecimal("89.99")))
                ))
        );

        Game myLittlePony = new Game("My little pony", "", new BigDecimal("20.00"));

        CART_SERVICE.addGameToCart(myLittlePony, userCart);

        CART_SERVICE.setRegionStrategy(RUSSIAN_REGION_STRATEGY);
        System.out.printf("%s %s%n", CART_SERVICE.calculateCartTotal(userCart), CART_SERVICE.getRegionStrategy().getCurrency());

        CART_SERVICE.setRegionStrategy(UNITED_STATES_REGION_STRATEGY);
        System.out.printf("%s %s%n", CART_SERVICE.calculateCartTotal(userCart), CART_SERVICE.getRegionStrategy().getCurrency());
    }
}
