package com.shop.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CacheService {

    private static final Map<Integer, Float> cachedProducts = new HashMap<>();


    public static Float findPriceById(int id) {
        return cachedProducts.get(id);
    }

    public static void addProduct(int id, Float price) {
        if (price != null) {
            cachedProducts.put(id, price);
        }
    }

    public static void clear() {
        cachedProducts.clear();
    }

}
