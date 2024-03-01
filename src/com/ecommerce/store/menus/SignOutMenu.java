package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.menus.interfaces.Menu;

public class SignOutMenu implements Menu {
    private AppContext appContext;

    {
        appContext = AppContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        appContext.setActiveCustomer(null);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- Sign Out --");
        System.out.println("Goodbye! Until next time :)");
    }
}