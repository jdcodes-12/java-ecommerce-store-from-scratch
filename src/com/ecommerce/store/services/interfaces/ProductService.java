package com.ecommerce.store.services.interfaces;

import com.ecommerce.store.models.interfaces.Product;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Product[] getProducts();
    Product getProductById(UUID productId);
}