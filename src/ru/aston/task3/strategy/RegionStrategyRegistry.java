package ru.aston.task3.strategy;

import java.util.Map;

public class RegionStrategyRegistry {
    private final Map<String, IRegionStrategy> regionStrategyMap;

    public RegionStrategyRegistry(Map<String, IRegionStrategy> regionStrategyMap) {
        this.regionStrategyMap = regionStrategyMap;
    }

    public IRegionStrategy getRegionStrategyByKey(final String key) {
        return regionStrategyMap.get(key);
    }
}
