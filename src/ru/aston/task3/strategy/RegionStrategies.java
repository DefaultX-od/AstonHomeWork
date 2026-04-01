package ru.aston.task3.strategy;

public enum RegionStrategies {
    RU(new RussianIRegionStrategy()),
    US(new UnitedStatesIRegionStrategy());

    private final IRegionStrategy regionStrategy;

    RegionStrategies(final IRegionStrategy regionStrategy) {
        this.regionStrategy = regionStrategy;
    }

    public IRegionStrategy getRegionStrategy() {
        return regionStrategy;
    }
}
