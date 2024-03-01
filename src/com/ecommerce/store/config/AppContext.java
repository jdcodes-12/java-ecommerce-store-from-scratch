package com.ecommerce.store.config;

import com.ecommerce.store.menus.interfaces.Menu;
import com.ecommerce.store.models.DefaultShopppingCart;
import com.ecommerce.store.models.interfaces.Customer;
import com.ecommerce.store.models.interfaces.ShoppingCart;

public class AppContext {
    private static AppContext instance;

    private Customer activeCustomer;
    private Menu mainMenu;
    private ShoppingCart sessionCart;

    private AppContext() {}

    public void setActiveCustomer(Customer customerToLogIn) {
        if (sessionCart != null)
            sessionCart.clear(); // we have to clear session cart when new user is logged in

        activeCustomer = customerToLogIn;
    }

    public Customer getActiveCustomer() {
        return this.activeCustomer;
    }

    public void setMainMenu(Menu menu) {
        mainMenu = menu;
    }

    public Menu getMainMenu() {
        return mainMenu;
    }

    public static AppContext getInstance() {
        if (instance == null)
            instance = new AppContext();

        return instance;
    }

    public ShoppingCart getSessionCart() {
        if (sessionCart == null)
            sessionCart = new DefaultShopppingCart();

        return sessionCart;
    }
}