package ru.aston.task3.strategy;

import java.math.BigDecimal;

public class GameStoreDemo {
    public final static RussianRegionStrategy RUSSIAN_REGION_STRATEGY = new RussianRegionStrategy();
    public final static UnitedStatesRegionStrategy UNITED_STATES_REGION_STRATEGY = new UnitedStatesRegionStrategy();

    public static void main(String[] args) {
        Game game = new Game("Death Stranding", "Some cool game", new BigDecimal("49.99"));
        CartItem cartItem = new CartItem(RUSSIAN_REGION_STRATEGY, game);
        System.out.println(cartItem.getRegionalPrice());
        cartItem.setRegionStrategy(UNITED_STATES_REGION_STRATEGY);
        System.out.println(cartItem.getRegionalPrice());
    }
}
