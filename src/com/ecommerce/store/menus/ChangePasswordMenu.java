package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.menus.interfaces.Menu;
import java.util.Scanner;

// TODO: Add input validations.
public class ChangePasswordMenu implements Menu {

    private AppContext appContext;

    {
        appContext = AppContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        try (Scanner keyboard = new Scanner(System.in)) {
            String userInput = keyboard.next();
            appContext.getActiveCustomer().setPassword(userInput);
            System.out.println("Password changed successfully!");
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println(":-: CHANGE PASSWORD :-:");
        System.out.print("Enter the desired password to use: ");
    }
}