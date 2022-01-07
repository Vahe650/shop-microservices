package com.shop.service.serviceImpl;

import com.shop.entity.Basket;
import com.shop.entity.CalculatedBasket;
import com.shop.exception.AddressNotFoundException;
import com.shop.exception.BasketException;
import com.shop.exception.UserNotFoundException;
import com.shop.service.CalculatedBasketService;
import com.shop.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CalculatedBasketServiceImpl implements CalculatedBasketService {

    @Value("${service-url}")
    private String serviceUrl;

    private final RestTemplate restTemplate;

    @Override
    public CalculatedBasket mapToCalculatedBasket(Basket basket) throws BasketException, UserNotFoundException, AddressNotFoundException {
        CalculatedBasket calculatedBasket = new CalculatedBasket();
        if (ValidationUtil.isValid(basket)) {
            Float totalPrice = basket
                    .getProducts()
                    .stream()
                    .map(product -> {
                        Float priceById = CacheService.findPriceById(product.getId());
                        if (priceById == null) {
                            String url = serviceUrl + product.getId();
                            priceById = restTemplate.getForObject(url, Float.class);
                            CacheService.addProduct(product.getId(), priceById);
                        }
                        product.setPositionAmount(priceById == null ? 0 : priceById * product.getCount());
                        return product.getPositionAmount();
                    })
                    .reduce(0f, Float::sum);
            calculatedBasket.setProducts(basket.getProducts());
            calculatedBasket.setTotalPrice(totalPrice);
        }
        return calculatedBasket;
    }
}
