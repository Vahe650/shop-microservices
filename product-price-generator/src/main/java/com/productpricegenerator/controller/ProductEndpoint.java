package com.productpricegenerator.controller;


import com.productpricegenerator.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping("/{id}")
    public Float getPrice(@PathVariable int id) {
        return productService.getPriceById(id);
    }
}
