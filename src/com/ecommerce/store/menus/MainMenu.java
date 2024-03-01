package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.enums.ConsoleCommand;
import com.ecommerce.store.menus.interfaces.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign In"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";;

    private AppContext appContext;

    {
        appContext = AppContext.getInstance();
    }

    @Override
    public void start() {

        while (true) {

            if (appContext.getMainMenu() == null)
                appContext.setMainMenu(this);

            Menu menuToNavigate;

            mainLoop: while (true) {
                printMenuHeader();

                Scanner keyboard = new Scanner(System.in);

                System.out.print("Menu choice: ");
                String userInput = keyboard.next();

                if (userInput.equalsIgnoreCase(ConsoleCommand.EXIT.getValue()))
                    System.exit(0);

                 else {
                    int commandNumber = Integer.parseInt(userInput);

                    switch (commandNumber) {
                        case 1:
                            menuToNavigate = new SignUpMenu();
                            break mainLoop;

                        case 2:
                            if (appContext.getActiveCustomer() == null)
                                menuToNavigate = new SignInMenu();

                            else menuToNavigate = new SignOutMenu();
                            break mainLoop;

                        case 3:
                            menuToNavigate = new ProductCatalogMenu();
                            break mainLoop;

                        case 4:
                            menuToNavigate = new CustomerOrdersMenu();
                            break mainLoop;

                        case 5:
                            menuToNavigate = new SettingsMenu();
                            break mainLoop;

                        case 6:
                            menuToNavigate = new CustomerListMenu();
                            break mainLoop;

                        default:
                            System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time");
                            continue; // continue endless loop
                    }
                }
            }

            menuToNavigate.start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- MAIN MENU --");

        if (appContext.getActiveCustomer() == null)
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);

        else System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
    }

}