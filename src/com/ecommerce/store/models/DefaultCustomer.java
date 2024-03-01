package com.ecommerce.store.models;

import com.ecommerce.store.models.interfaces.Customer;
import java.util.UUID;

public class DefaultCustomer implements Customer {

    private UUID customerId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    {
        customerId = UUID.randomUUID();
    }

    public DefaultCustomer() {}

    public DefaultCustomer(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public UUID getCustomerId() {
        return customerId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setPassword(String password) {
        if (password == null) return;
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
       if (email == null) return;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DefaultCustomer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}