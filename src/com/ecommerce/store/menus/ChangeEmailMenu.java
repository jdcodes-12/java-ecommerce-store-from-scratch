package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.menus.interfaces.Menu;
import java.util.Scanner;

// TODO: Add input validations.
public class ChangeEmailMenu implements Menu {

    private AppContext appContext;

    {
        appContext = AppContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        try(Scanner keyboard = new Scanner(System.in)) {
            String customerEmail = keyboard.next();
            appContext.getActiveCustomer().setEmail(customerEmail);
            System.out.println("Email changed successfully!");
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println(":-: CHANGE EMAIL :-:");
        System.out.print("Enter the desired email to use: ");
    }
}