package utils;

public class InputValidator {
    public static boolean validate(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
