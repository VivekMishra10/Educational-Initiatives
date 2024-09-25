package main;

import adapter.InputAdapter;
import utils.Logger;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Logger.info("Application started...");
        InputAdapter adapter = new InputAdapter();
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Logger.info("Press 'q' to quit or any other key to gather input...");
            String input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input)) {
                Logger.info("Exiting application...");
                break;
            }

            try {
                adapter.handleInput();
            } catch (Exception e) {
                Logger.error("Error occurred: " + e.getMessage());
            }
        }
    }
}
