package factory;

import logging.Logger;

public class Bike implements Vehicle {
    @Override
    public void drive() {
        Logger.log("Riding a bike.");
    }
}
