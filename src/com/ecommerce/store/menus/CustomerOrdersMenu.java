package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.enums.MenuType;
import com.ecommerce.store.menus.interfaces.Menu;
import com.ecommerce.store.models.interfaces.Order;
import com.ecommerce.store.services.OrderManagementService;
import com.ecommerce.store.services.interfaces.OrderService;

import java.util.Optional;
import java.util.UUID;

public class CustomerOrdersMenu implements Menu {

    private AppContext appContext;
    private OrderService orderManagementService;

    {
        appContext = AppContext.getInstance();
        orderManagementService = OrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        if (appContext.getActiveCustomer() == null) {
            System.out.println("Cannot view your orders because you are not logged in.");
            System.out.println("Log in or create new account to see list of your orders.");

            MenuFactory.createMenu(MenuType.MAIN).start();
            return;
        }

        else printUserOrdersToConsole();
    }

    private void printUserOrdersToConsole() {
        UUID customerIdToFind = appContext.getActiveCustomer().getCustomerId();

        Order[] activeCustomerOrders =
            orderManagementService.getOrdersByCustomerId(customerIdToFind);

        if (activeCustomerOrders.length == 0)
            System.out.println(
                "You currently have no orders. " +
                "Navigate back to the main menu to place an order."
            );

        else for (Order order : activeCustomerOrders)
                System.out.println(order);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- MY ORDERS --");
    }
}