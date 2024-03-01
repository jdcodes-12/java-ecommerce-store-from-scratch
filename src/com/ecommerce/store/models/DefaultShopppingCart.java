package com.ecommerce.store.models;

import com.ecommerce.store.models.interfaces.Product;
import com.ecommerce.store.models.interfaces.ShoppingCart;

import java.util.Arrays;

public class DefaultShopppingCart implements ShoppingCart {
    private static final int DEFAULT_CART_CAPACITY = 10;
    private Product[] products;
    private int lastProductIndex = 0;

    {
        products = new Product[DEFAULT_CART_CAPACITY];
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) return;

        // Resize if the array is at max capacity.
        if (products.length <= lastProductIndex)
            products = Arrays.copyOf(products, products.length << 1);

        products[lastProductIndex++] = product;
    }

    @Override
    public Product[] getProducts() {
        return Arrays.stream(products)
                .filter(product -> product != null)
                .toArray(Product[]::new);
    }

    /*
     * An array of Products is considered "empty" if it
     * contains all null values, is null itself, or
     * the length is zero.
     */
    @Override
    public boolean isEmpty() {
        if (products == null || products.length == 0)
            return true;

        for (Product product : products)
            if (product != null) return false;

        return true;
    }

    @Override
    public void clear() {
        products = new Product[DEFAULT_CART_CAPACITY];
    }
}