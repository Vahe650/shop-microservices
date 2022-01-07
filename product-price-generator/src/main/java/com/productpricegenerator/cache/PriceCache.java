package com.productpricegenerator.cache;

import java.util.HashMap;
import java.util.Map;

public class PriceCache {

    private static final Map<Integer, Float> cachedProducts = new HashMap<>();

    public static Float findPriceById(int id) {
        return cachedProducts.get(id);
    }

    public static void addProduct(int id, float price) {
        cachedProducts.put(id, price);
    }

    public static void clear() {
        cachedProducts.clear();
    }

    public static int getSize() {
        return cachedProducts.size();
    }
}
