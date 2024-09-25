package adapter;

import legacy.LegacyInputHandler;
import newsystem.NewInputHandler;
import utils.Logger;

public class InputAdapter {
    private LegacyInputHandler legacyHandler;
    private NewInputHandler newHandler;

    public InputAdapter() {
        this.legacyHandler = new LegacyInputHandler();
        this.newHandler = new NewInputHandler();
    }

    public void handleInput() {
        Logger.info("Adapting legacy input for new system...");
        String legacyInput = legacyHandler.fetchLegacyInput();
        newHandler.processInput(legacyInput);
    }
}
