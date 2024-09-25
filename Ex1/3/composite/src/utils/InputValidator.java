package utils;

public class InputValidator {
    
    // Validate button label: should not be null or empty and should have a reasonable length
    public static boolean validateButtonLabel(String label) {
        if (label == null || label.trim().isEmpty()) {
            return false;
        }
        return label.length() <= 50; // Arbitrary max length for button labels
    }

    // Validate text field content: should not be null or empty and should have a reasonable length
    public static boolean validateTextFieldContent(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        return text.length() <= 200; // Arbitrary max length for text field content
    }
}
