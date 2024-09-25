import config.ConfigurationManager;
import logging.Logger;
import exception.CustomException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger.log("Singleton Pattern: Configuration Management");
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Get Configuration");
            System.out.println("2. Update Configuration");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear the buffer

            switch (choice) {
                case 1:
                    Logger.log("Current configuration: " + configManager.getConfig());
                    break;
                case 2:
                    System.out.print("Enter new configuration: ");
                    String newConfig = scanner.nextLine();
                    try {
                        configManager.updateConfig(newConfig);
                    } catch (CustomException e) {
                        Logger.log("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    Logger.log("Exiting...");
                    exit = true;
                    break;
                default:
                    Logger.log("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
