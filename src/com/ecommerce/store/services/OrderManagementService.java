package com.ecommerce.store.services;

import com.ecommerce.store.models.interfaces.Order;
import com.ecommerce.store.services.interfaces.OrderService;
import java.util.Arrays;
import java.util.UUID;

public class OrderManagementService implements OrderService {
    private static final int DEFAULT_ORDER_CAPACITY = 10;

    private static OrderManagementService instance;
    private int lastOrderIndex;
    private Order[] orders;

    {
        orders = new Order[DEFAULT_ORDER_CAPACITY];
    }

    public static OrderManagementService getInstance() {
        if (instance == null)
            instance = new OrderManagementService();

        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) return;

        if (orders.length <= lastOrderIndex)
            orders = Arrays.copyOf(orders, orders.length << 1);

        orders[lastOrderIndex++] = order;
    }

    @Override
    public Order[] getOrdersByCustomerId(UUID customerId) {
        return Arrays.stream(orders)
                .filter(order ->
                    order != null &&
                    order.getCustomerId().equals(customerId)
                ).toArray(Order[]::new);
    }

    @Override
    public Order[] getOrders() {
        return Arrays.stream(orders)
                .filter(order -> order != null)
                .toArray(Order[]::new);
    }

    public void clearServiceState() {
        lastOrderIndex = 0;
        orders = new Order[DEFAULT_ORDER_CAPACITY];
    }
}