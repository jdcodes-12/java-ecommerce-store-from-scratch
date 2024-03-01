package com.ecommerce.store.models.interfaces;

import java.util.UUID;

public interface Product {
    UUID getProductId();
    String getProductName();
}