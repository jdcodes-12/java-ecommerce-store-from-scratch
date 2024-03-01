package com.ecommerce.store.models;

import com.ecommerce.store.models.interfaces.Order;
import com.ecommerce.store.models.interfaces.Product;
import java.util.Arrays;
import java.util.UUID;

public class DefaultOrder implements Order {

    private static final short ALLOWED_CREDIT_CARD_DIGITS = 16;

    private String creditCardNumber;
    private Product[] products;
    private UUID customerId;

    @Override
    public UUID getCustomerId() {
        return this.customerId;
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        if (creditCardNumber == null) return;
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void setProducts(Product[] products) {
        if (products == null) return;
        this.products = products;
    }

    @Override
    public void setCustomerId(UUID customerId) {
        if (customerId == null) return;
        this.customerId = customerId;
    }

    @Override
    public boolean isValidCreditCardNumber(String creditCardNumber) {
        return (
            creditCardNumber.toCharArray().length == ALLOWED_CREDIT_CARD_DIGITS
            && !creditCardNumber.contains(" ")
            && Long.parseLong(creditCardNumber) > 0
        );
    }

    @Override
    public String toString() {
        return "DefaultOrder{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", products=" + Arrays.toString(products) +
                ", customerId=" + customerId +
                '}';
    }
}