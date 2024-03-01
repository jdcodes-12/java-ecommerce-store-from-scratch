package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.menus.interfaces.Menu;
import com.ecommerce.store.models.interfaces.Customer;
import com.ecommerce.store.services.CustomerManagementService;
import com.ecommerce.store.services.interfaces.CustomerService;

import java.util.Optional;

public class CustomerListMenu implements Menu {

    private AppContext appContext;
    private CustomerService customerManagementService;

    {
        customerManagementService = CustomerManagementService.getInstance();
        appContext = AppContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Customer[] customers = customerManagementService.getCustomers();

        if (customers.length == 0)
            System.out.println("No customers exist currently.");

        else for (Customer customer : customers)
            System.out.println(customer);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- CUSTOMERS --");
    }
}