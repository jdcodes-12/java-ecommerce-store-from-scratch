package com.ecommerce.store.models.interfaces;

import java.util.UUID;

public interface Customer {
    UUID getCustomerId();
    String getFirstName();
    String getLastName();
    String getPassword();
    String getEmail();

    void setPassword(String password);
    void setEmail(String email);
}