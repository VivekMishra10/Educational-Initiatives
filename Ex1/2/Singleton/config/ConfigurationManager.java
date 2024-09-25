package config;

import logging.Logger;
import exception.CustomException;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String config;

    private ConfigurationManager() {
        config = "Default Configuration";
        Logger.log("ConfigurationManager initialized.");
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void updateConfig(String newConfig) throws CustomException {
        if (newConfig == null || newConfig.isEmpty()) {
            throw new CustomException("Invalid configuration provided.");
        }
        config = newConfig;
        Logger.log("Configuration updated to: " + newConfig);
    }
}
