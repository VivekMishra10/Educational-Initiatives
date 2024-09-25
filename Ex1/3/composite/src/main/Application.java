package main;

import composite.Button;
import composite.Composite;
import composite.TextField;
import utils.InputValidator;
import utils.Logger;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Logger.info("Application started...");
        Composite root = new Composite();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Logger.info("Enter component type (button/text/quit): ");
            String input = scanner.nextLine();
            
            if ("quit".equalsIgnoreCase(input)) {
                Logger.info("Exiting application...");
                break;
            }

            switch (input.toLowerCase()) {
                case "button":
                    Logger.info("Enter button label: ");
                    String label = scanner.nextLine();
                    
                    // Validate button label
                    if (InputValidator.validateButtonLabel(label)) {
                        root.add(new Button(label));
                    } else {
                        Logger.error("Invalid button label. Please enter a valid label (non-empty, max 50 characters).");
                    }
                    break;
                case "text":
                    Logger.info("Enter text field content: ");
                    String text = scanner.nextLine();
                    
                    // Validate text field content
                    if (InputValidator.validateTextFieldContent(text)) {
                        root.add(new TextField(text));
                    } else {
                        Logger.error("Invalid text field content. Please enter valid text (non-empty, max 200 characters).");
                    }
                    break;
                default:
                    Logger.error("Unknown component type");
            }
            root.render();
        }
    }
}
