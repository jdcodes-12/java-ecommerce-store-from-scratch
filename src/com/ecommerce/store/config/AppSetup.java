package com.ecommerce.store.config;

import com.ecommerce.store.models.DefaultProduct;
import com.ecommerce.store.models.interfaces.Product;

import java.math.BigDecimal;

public class AppSetup {
    public static Product[] initProducts() {
        return new Product[] {
            new DefaultProduct("Nike SB Dunk", "Shoes", BigDecimal.valueOf(149.99)),
            new DefaultProduct("Nike Air Force 1", "Shoes", BigDecimal.valueOf(139.99)),
            new DefaultProduct("Nike Jordan 1 Retro High Gray", "Shoes", BigDecimal.valueOf(159.99)),
            new DefaultProduct("Adidas Yeezy Foam Slides", "Shoes", BigDecimal.valueOf(149.99)),
            new DefaultProduct("Adidas Samba OG Court", "Shoes", BigDecimal.valueOf(129.99)),
            new DefaultProduct("Nike Jordan 4 Retro Red Black", "Shoes", BigDecimal.valueOf(249.99)),
            new DefaultProduct("Adidas Gazelle Scarlet Cloud White", "Shoes", BigDecimal.valueOf(149.00)),
            new DefaultProduct("New Balance 9060 All Black", "Shoes", BigDecimal.valueOf(167.99)),
            new DefaultProduct("Casio Analog Smoke Gray Watch", "Accessories", BigDecimal.valueOf(74.99)),
            new DefaultProduct("Fear of God Hoodie Sycamore Large Mens", "Apparel", BigDecimal.valueOf(59.99))
        };
    }
}