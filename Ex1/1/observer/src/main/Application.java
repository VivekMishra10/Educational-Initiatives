package main;

import observer.StockPriceNotifier;
import subject.Stock;
import utils.InputValidator;
import utils.Logger;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Logger.info("Application started...");
        Stock stock = new Stock();

        StockPriceNotifier observer1 = new StockPriceNotifier("Client 1");
        StockPriceNotifier observer2 = new StockPriceNotifier("Client 2");

        stock.addObserver(observer1);
        stock.addObserver(observer2);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Logger.info("Enter new stock price (or type 'q' to quit): ");
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
            stock.setPrice(price);
        }
    }
}
