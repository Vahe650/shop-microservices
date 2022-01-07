package com.shop.exception;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException() {
        super("address not found");
    }

}
