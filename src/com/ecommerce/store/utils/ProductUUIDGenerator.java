package com.ecommerce.store.utils;

public class ProductUUIDGenerator {
    public static String generateProductUUIDString() {
        String prefix = "P";
        String randomPart = generateRandomString(5);
        return prefix + randomPart;
    }

    private static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            randomString.append(randomChar);
        }
        return randomString.toString();
    }
}