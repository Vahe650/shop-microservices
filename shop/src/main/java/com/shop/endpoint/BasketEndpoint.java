package com.shop.endpoint;

import com.shop.entity.Basket;
import com.shop.entity.CalculatedBasket;
import com.shop.exception.AddressNotFoundException;
import com.shop.exception.BasketException;
import com.shop.exception.UserNotFoundException;
import com.shop.service.CalculatedBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketEndpoint {

    private final CalculatedBasketService calculatedBasketService;

    @GetMapping
    public CalculatedBasket basket(@RequestBody Basket basket)
            throws BasketException,
            UserNotFoundException,
            AddressNotFoundException {
        return calculatedBasketService.mapToCalculatedBasket(basket);
    }
}
