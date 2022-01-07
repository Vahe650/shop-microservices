package com.shop.exception;

public class BasketException extends RuntimeException {

    public BasketException() {
        super("Basket is empty");
    }

}
