package com.shop.entity;

import com.shop.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Basket {

    private List<Product> products;

    private int addressId;

    private int userId;

    private PaymentType paymentType;

}
