package utils;

public class InputValidator {
    public static boolean validatePrice(String price) {
        try {
            double value = Double.parseDouble(price);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
