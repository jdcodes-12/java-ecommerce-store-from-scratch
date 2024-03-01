package com.ecommerce.store;

import com.ecommerce.store.enums.MenuType;
import com.ecommerce.store.menus.MenuFactory;
import com.ecommerce.store.menus.interfaces.Menu;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = MenuFactory.createMenu(MenuType.MAIN);
        mainMenu.start();
    }
}