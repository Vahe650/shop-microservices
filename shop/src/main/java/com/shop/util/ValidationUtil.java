package com.shop.util;

import com.shop.entity.Basket;
import com.shop.exception.AddressNotFoundException;
import com.shop.exception.BasketException;
import com.shop.exception.UserNotFoundException;

public class ValidationUtil {

    public static boolean isValid(Basket basket)
            throws UserNotFoundException, AddressNotFoundException, BasketException {
        if (basket.getUserId() <= 0) {
            throw new UserNotFoundException();
        } else if (basket.getAddressId() <= 0) {
            throw new AddressNotFoundException();
        } else if (basket.getProducts().isEmpty()) {
            throw new BasketException();
        }
        return true;
    }
}
