package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.enums.ConsoleCommand;
import com.ecommerce.store.menus.interfaces.Menu;

import java.util.Scanner;

public class SettingsMenu implements Menu {

    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
            + "2. Change Email";

    private AppContext appContext;

    {
        appContext = AppContext.getInstance();
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        mainLoop: while (true) {
            printMenuHeader();
            if (appContext.getActiveCustomer() == null) {
                System.out.println(
                    "Please, log in or create new account to change your account settings"
                );

                new MainMenu().start();
                return;

            } else {
                System.out.println(SETTINGS);
                System.out.print("Please, enter option or type 'menu' to navigate back to the main menu: ");

                Scanner keyboard = new Scanner(System.in);
                String userInput = keyboard.next();

                if (userInput.equalsIgnoreCase(ConsoleCommand.SHOW_MENU.getValue())) {
                    menuToNavigate = new MainMenu();
                    break mainLoop;
                }

                int userOption = Integer.parseInt(userInput);

                switch (userOption) {
                    case 1:
                        menuToNavigate = new ChangePasswordMenu();
                        break mainLoop;
                    case 2:
                        menuToNavigate = new ChangeEmailMenu();
                        break mainLoop;

                    default:
                        System.out.println("Only 1, 2 is allowed. Try one more time");
                        continue;
                }
            }
        }

        menuToNavigate.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- USER SETTINGS --");
    }
}