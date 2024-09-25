package factory;

import logging.Logger;

public class Car implements Vehicle {
    @Override
    public void drive() {
        Logger.log("Driving a car.");
    }
}
