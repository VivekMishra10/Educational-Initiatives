package newsystem;

import utils.InputValidator;
import utils.Logger;

public class NewInputHandler {
    public void processInput(String input) {
        if (!InputValidator.validate(input)) {
            Logger.error("Invalid input");
            throw new IllegalArgumentException("Input is invalid");
        }
        Logger.info("Processing input in new system: " + input);
    }
}
