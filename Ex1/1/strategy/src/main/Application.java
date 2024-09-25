package main;

import context.ShoppingCart;
import strategy.BlackFridayDiscount;
import strategy.NoDiscount;
import strategy.SeasonalDiscount;
import utils.InputValidator;
import utils.Logger;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Logger.info("Application started...");
        ShoppingCart cart = new ShoppingCart();
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Logger.info("Enter product price (or type 'q' to quit): ");
            String priceInput = scanner.nextLine();
            
            if ("q".equalsIgnoreCase(priceInput)) {
                Logger.info("Exiting application...");
                break;
            }
            
            if (!InputValidator.validatePrice(priceInput)) {
                Logger.error("Invalid price. Please enter a valid number.");
                continue;
            }

            double price = Double.parseDouble(priceInput);

            Logger.info("Choose discount type (none/seasonal/blackfriday): ");
            String discountType = scanner.nextLine();

            switch (discountType.toLowerCase()) {
                case "none":
                    cart.setDiscountStrategy(new NoDiscount());
                    break;
                case "seasonal":
                    cart.setDiscountStrategy(new SeasonalDiscount());
                    break;
                case "blackfriday":
                    cart.setDiscountStrategy(new BlackFridayDiscount());
                    break;
                default:
                    Logger.error("Unknown discount type. Please try again.");
                    continue;
            }

            double finalPrice = cart.calculateFinalPrice(price);
            Logger.info("Final price after discount: $" + finalPrice);
        }
    }
}
