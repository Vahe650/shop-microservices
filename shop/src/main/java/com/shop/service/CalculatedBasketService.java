package com.shop.service;

import com.shop.entity.Basket;
import com.shop.entity.CalculatedBasket;
import com.shop.exception.AddressNotFoundException;
import com.shop.exception.BasketException;
import com.shop.exception.UserNotFoundException;

public interface CalculatedBasketService {

    CalculatedBasket mapToCalculatedBasket(Basket basket)
            throws BasketException, UserNotFoundException, AddressNotFoundException;

}
