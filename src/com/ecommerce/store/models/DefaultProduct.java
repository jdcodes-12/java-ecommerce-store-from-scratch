package com.ecommerce.store.models;

import com.ecommerce.store.models.interfaces.Product;
import com.ecommerce.store.utils.ProductUUIDGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class DefaultProduct implements Product {
    private UUID productId;
    private String productName;
    private String categoryName;
    private BigDecimal price;

    {
        productId = UUID.fromString(ProductUUIDGenerator.generateProductUUIDString());
    }

    public DefaultProduct() {}

    public DefaultProduct( String productName, String categoryName, BigDecimal price) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public UUID getProductId() {
        return productId;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public String toString() {
        return "DefaultProduct{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price.setScale(2, RoundingMode.DOWN) +
                '}';
    }
}