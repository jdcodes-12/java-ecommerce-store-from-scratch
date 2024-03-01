package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.menus.interfaces.Menu;
import com.ecommerce.store.models.DefaultOrder;
import com.ecommerce.store.models.interfaces.Order;
import com.ecommerce.store.services.OrderManagementService;
import com.ecommerce.store.services.interfaces.OrderService;

import java.util.Scanner;

public class OrderCheckoutMenu implements Menu {

    private AppContext appContext;
    private OrderService orderManagementService;

    {
        appContext = AppContext.getInstance();
        orderManagementService = OrderManagementService.getInstance();
    }

    @Override
    public void start() {
        try (Scanner keyboard = new Scanner(System.in)) {
            while (true) {
                printMenuHeader();
                String creditCardNumber = keyboard.next();

                if (!createOrder(creditCardNumber)) continue;

                appContext.getSessionCart().clear();
                break;
            }
        }

        System.out.println("Thanks for shopping with us!! :)");
        System.out.println("Details about your order delivery will be sent to your email soon.");
    }

    // TODO: Move Credit Card validation into own class.
    private boolean createOrder(String creditCardNumber) {
        Order order = new DefaultOrder();

        if (!order.isValidCreditCardNumber(creditCardNumber))
            return false;

        order.setCreditCardNumber(creditCardNumber);
        order.setProducts(appContext.getSessionCart().getProducts());
        order.setCustomerId(appContext.getActiveCustomer().getCustomerId());

        orderManagementService.addOrder(order);
        return true;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-- CHECKOUT --");
        System.out.print(
            "Enter a credit card number without spaces. Press enter to confirm the purchase: "
        );
    }
}