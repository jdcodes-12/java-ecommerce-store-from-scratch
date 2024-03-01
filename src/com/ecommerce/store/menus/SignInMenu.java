package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.menus.interfaces.Menu;
import com.ecommerce.store.models.interfaces.Customer;
import com.ecommerce.store.services.CustomerManagementService;
import com.ecommerce.store.services.interfaces.CustomerService;

import java.util.Optional;
import java.util.Scanner;

public class SignInMenu implements Menu {

    private AppContext appContext;
    private CustomerService customerManagementService;

    {
        appContext = AppContext.getInstance();
        customerManagementService = CustomerManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please, enter your email: ");
        String userEmail = keyboard.next();

        System.out.print("Please, enter your password: ");
        String userPassword = keyboard.next();

        Customer customer =
            customerManagementService.getCustomerByEmail(userEmail);

        if (customer != null) {
            Customer activeCustomer = customer;

            if (activeCustomer.getPassword().equals(userPassword)) {
                System.out.printf(
                    "Glad to see you back %s %s",
                    activeCustomer.getFirstName(),
                    activeCustomer.getLastName() + System.lineSeparator()
                );

                appContext.setActiveCustomer(activeCustomer);
            }
        }
        else System.out.println("Unfortunately, such login and password doesn't exist");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- Sign In --");
    }
}