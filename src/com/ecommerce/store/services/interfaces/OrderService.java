package com.ecommerce.store.services.interfaces;

import com.ecommerce.store.models.interfaces.Order;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    void addOrder(Order order);
    Order[] getOrdersByCustomerId(UUID customerId);
    Order[] getOrders();
}