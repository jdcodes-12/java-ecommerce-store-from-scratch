package com.ecommerce.store.menus;

import com.ecommerce.store.enums.MenuType;
import com.ecommerce.store.menus.interfaces.Menu;

public class MenuFactory {

    public static Menu createMenu(MenuType menuType) {
        switch(menuType) {
            case CHANGE_EMAIL:
                return new ChangeEmailMenu();

            case CHANGE_PASSWORD:
                return new ChangePasswordMenu();

            case CHECKOUT:
                return new OrderCheckoutMenu();

            case CUSTOMER_LIST:
                return new CustomerListMenu();

            case CUSTOMER_ORDERS:
                return new CustomerOrdersMenu();

            case PRODUCT_CATALOG:
                return new ProductCatalogMenu();

            case SETTINGS:
                return new SettingsMenu();

            case SIGN_IN:
                return new SignInMenu();

            case SIGN_OUT:
                return new SignOutMenu();

            case SIGN_UP:
                return new SignUpMenu();

            case MAIN:
                return new MainMenu();

            default:
                throw new IllegalArgumentException("Invalid menu enum type passed to factory.");
        }
    }
}