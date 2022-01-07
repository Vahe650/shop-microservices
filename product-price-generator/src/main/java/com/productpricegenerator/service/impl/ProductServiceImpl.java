package com.productpricegenerator.service.impl;

import com.productpricegenerator.cache.PriceCache;
import com.productpricegenerator.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private static final int DEFAULT_PRODUCTS_SIZE = 1000;

    @PostConstruct
    void init() {
        for (int i = 1; i < DEFAULT_PRODUCTS_SIZE; i++) {
            PriceCache.addProduct(i, i + 55.5f);
        }
        log.info("Added {} products to application", PriceCache.getSize());
    }

    @Override
    public float getPriceById(int productId) {
        return PriceCache.findPriceById(productId);
    }
}
