package ru.aston.task3.strategy;

public class GameStore {
    private final CartService cartService;

    public GameStore(final CartService cartService) {
        this.cartService = cartService;
    }

    public void run(final Cart cart, final String strategyKey){
        final IRegionStrategy regionStrategy = cartService.getRegionStrategyRegistry().getRegionStrategyByKey(strategyKey);
        System.out.printf("%s %s%n", cartService.calculateCartTotal(cart, regionStrategy), regionStrategy.getCurrency());
    }
}
