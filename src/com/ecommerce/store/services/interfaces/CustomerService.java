package com.ecommerce.store.services.interfaces;

import com.ecommerce.store.models.interfaces.Customer;
import java.util.Optional;

public interface CustomerService {
    String registerCustomer(Customer customer);
    Customer[] getCustomers();
    Customer getCustomerByEmail(String customerEmail);
}