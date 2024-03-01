package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.menus.interfaces.Menu;
import com.ecommerce.store.models.DefaultCustomer;
import com.ecommerce.store.models.interfaces.Customer;
import com.ecommerce.store.services.CustomerManagementService;
import com.ecommerce.store.services.interfaces.CustomerService;
import java.util.Scanner;

public class SignUpMenu implements Menu {

    private CustomerService customerManagementService;
    private AppContext context;

    {
        customerManagementService = CustomerManagementService.getInstance();
        context = AppContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please, enter your first name: ");
        String firstName = keyboard.next();

        System.out.print("Please, enter your last name: ");
        String lastName = keyboard.next();

        System.out.print("Please, enter your password: ");
        String password = keyboard.next();

        System.out.print("Please, enter your email: ");

        keyboard = new Scanner(System.in);
        String email = keyboard.nextLine();

        Customer customer = new DefaultCustomer(firstName, lastName, password, email);

        String errorMessage = customerManagementService.registerCustomer(customer);

        if (errorMessage == null || errorMessage.isEmpty()) {
            context.setActiveCustomer(customer);
            System.out.println("New user is created");
        }
        else System.out.println(errorMessage);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- SIGN UP --");
    }
}