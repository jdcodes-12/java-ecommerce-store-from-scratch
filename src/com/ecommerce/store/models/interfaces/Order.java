package com.ecommerce.store.models.interfaces;

import java.util.UUID;

public interface Order {
    UUID getCustomerId();

    void setCreditCardNumber(String creditCardNumber);
    void setProducts(Product[] products);
    void setCustomerId(UUID customerId);

    boolean isValidCreditCardNumber(String creditCardNumber);
}