package com.ecommerce.store.services;

import com.ecommerce.store.models.interfaces.Customer;
import com.ecommerce.store.services.interfaces.CustomerService;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

// TODO: Convert to Optionals instead of returning null
public class CustomerManagementService implements CustomerService {

    private static final int DEFAULT_CUSTOMER_CAPACITY = 10;

    private static CustomerManagementService instance;

    private Customer[] customers;
    private int lastCustomerIndex;

    {
        customers = new Customer[DEFAULT_CUSTOMER_CAPACITY];
    }

    private CustomerManagementService() {}

    public static CustomerManagementService getInstance() {
        if (instance == null)
            instance = new CustomerManagementService();

        return instance;
    }

    @Override
    public String registerCustomer(Customer customer) {
        if (customer == null)
            return CustomerRegistrationMessage.NO_ERROR.getMessage();

        String errorMessage = checkEmailUniqueness(customer.getEmail());

        if (errorMessage != null && !errorMessage.isEmpty())
            return errorMessage;

        if (customers.length <= lastCustomerIndex)
            customers = Arrays.copyOf(customers, customers.length << 1);

        customers[lastCustomerIndex++] = customer;

        return CustomerRegistrationMessage.NO_ERROR.getMessage();
    }

    @Override
    public Customer[] getCustomers() {
        return Arrays.stream(customers)
                .filter(customer -> customer != null)
                .toArray(Customer[]::new);
    }

    @Override
    public Customer getCustomerByEmail(String customerEmail) {
        for (Customer customer : customers) {
            boolean customerEmailMatchesPassedEmail =
                    customer.getEmail().equalsIgnoreCase((customerEmail));

            if (customer != null && customerEmailMatchesPassedEmail)
                return customer;
        }

        return null;
    }

    public void clearServiceState() {
        lastCustomerIndex = 0;
        customers = new Customer[DEFAULT_CUSTOMER_CAPACITY];
    }

    private String checkEmailUniqueness(String email) {
        if (email == null|| email.isEmpty())
            return CustomerRegistrationMessage.EMPTY_EMAIL.getMessage();

        for (Customer customer : customers) {
            if (customer == null) continue;

            String customerEmail = customer.getEmail();

            if (customerEmail != null && customerEmail.equalsIgnoreCase(email))
                return CustomerRegistrationMessage.NOT_UNIQUE_EMAIL.getMessage();
        }

        return CustomerRegistrationMessage.NO_ERROR.getMessage();
    }

    private enum CustomerRegistrationMessage {
        NOT_UNIQUE_EMAIL("This email is already taken by another customer."),
        EMPTY_EMAIL("No customer has been entered. Try again."),
        NO_ERROR("");

        private final String message;

        CustomerRegistrationMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}