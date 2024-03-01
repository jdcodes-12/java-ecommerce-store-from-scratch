package com.ecommerce.store.services;

import com.ecommerce.store.config.AppSetup;
import com.ecommerce.store.models.interfaces.Product;
import com.ecommerce.store.services.interfaces.ProductService;

import java.util.UUID;

public class ProductManagementService implements ProductService {
    private static ProductManagementService instance;

    private static Product[] products;

    static {
        products = AppSetup.initProducts();
    }

    private ProductManagementService() {}

    public static ProductManagementService getInstance() {
        if (instance == null)
            instance = new ProductManagementService();

        return instance;
    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public Product getProductById(UUID productIdToAddToCart) {
        for (Product product : products)
            if (product != null && product.getProductId().equals(productIdToAddToCart))
                return product;

        return null;
    }
}