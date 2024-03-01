package com.ecommerce.store.enums;

public enum ConsoleCommand {
    EXIT("exit"),
    SHOW_MENU("menu"),
    GO_TO_CHECKOUT("checkout");

    private final String value;

    ConsoleCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
