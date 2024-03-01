package com.ecommerce.store.models.interfaces;

import com.ecommerce.store.models.interfaces.Product;

public interface ShoppingCart {
    void addProduct(Product productById);
    Product[] getProducts();

    boolean isEmpty();
    void clear();
}