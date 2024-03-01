package com.ecommerce.store.menus;

import com.ecommerce.store.config.AppContext;
import com.ecommerce.store.enums.ConsoleCommand;
import com.ecommerce.store.enums.MenuType;
import com.ecommerce.store.menus.interfaces.Menu;
import com.ecommerce.store.models.interfaces.Product;
import com.ecommerce.store.models.interfaces.ShoppingCart;
import com.ecommerce.store.services.ProductManagementService;
import com.ecommerce.store.services.interfaces.ProductService;

import java.util.Scanner;
import java.util.UUID;

public class ProductCatalogMenu implements Menu {

    private AppContext appContext;
    private ProductService productManagementService;

    {
        appContext = AppContext.getInstance();
        productManagementService = ProductManagementService.getInstance();
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        while (true) {
            printMenuHeader();
            printProductsToConsole();

            String userInput = readUserInput();

            if (appContext.getActiveCustomer() == null) {
                menuToNavigate = new MainMenu();
                System.out.println("You are not logged in. Please, sign in or create new account");
                break;
            }

            if (userInput.equalsIgnoreCase(ConsoleCommand.SHOW_MENU.getValue())) {
                menuToNavigate = new MainMenu();
                break;
            }

            if (userInput.equalsIgnoreCase(ConsoleCommand.GO_TO_CHECKOUT.getValue())) {
                ShoppingCart sessionCart = appContext.getSessionCart();
                if (sessionCart == null || sessionCart.isEmpty())
                    System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");

                else {
                    menuToNavigate = MenuFactory.createMenu(MenuType.CHECKOUT);
                    break;
                }

            } else {
                Product productToAddToCart = fetchProduct(UUID.fromString(userInput));

                if (productToAddToCart == null) {
                    System.out.println("Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
                    continue;
                }

                processAddToCart(productToAddToCart);
            }
        }

        menuToNavigate.start();
    }

    private String readUserInput() {
        System.out.print("Product ID to add to cart or enter 'checkout' to proceed with checkout: ");
        try (Scanner keyboard = new Scanner(System.in)) {
            String userInput = keyboard.next();
            return userInput;
        }
    }

    private void printProductsToConsole() {
        Product[] products = productManagementService.getProducts();

        for (Product product : products)
            System.out.println(product);
    }

    private Product fetchProduct(UUID  productToFind) {
        return productManagementService.getProductById(productToFind);
    }

    private void processAddToCart(Product productToAddToCart) {
        appContext.getSessionCart().addProduct(productToAddToCart);
        System.out.printf("Product %s has been added to your cart. "
                + "If you want to add a new product - enter the product id. "
                + "If you want to proceed with checkout - enter word "
                + "'checkout' to console %n", productToAddToCart.getProductName());
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** PRODUCT CATALOG *****");
        System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
    }

}