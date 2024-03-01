package com.ecommerce.store.config;

import com.ecommerce.store.models.DefaultProduct;
import com.ecommerce.store.models.interfaces.Product;

import java.math.BigDecimal;

public class AppSetup {
    public static Product[] initProducts() {
        return new Product[] {
            new DefaultProduct("Hardwood Oak Suffolk Internal Door", "Doors", BigDecimal.valueOf(109.99)),
            new DefaultProduct("Oregon Cottage Interior Oak Door", "Doors", BigDecimal.valueOf(179.99)),
            new DefaultProduct("Oregon Cottage Horizontal Interior White Oak Door", "Doors", BigDecimal.valueOf(189.99)),
            new DefaultProduct("4 Panel Oak Deco Interior Door", "Doors", BigDecimal.valueOf(209.09)),
            new DefaultProduct("Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", BigDecimal.valueOf(989.99)),
            new DefaultProduct("Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", BigDecimal.valueOf(787.99)),
            new DefaultProduct("Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", BigDecimal.valueOf(859.99)),
            new DefaultProduct("Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", BigDecimal.valueOf(402.99)),
            new DefaultProduct("Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", BigDecimal.valueOf(659.99)),
            new DefaultProduct("Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", BigDecimal.valueOf(523.99))
        };
    }
}