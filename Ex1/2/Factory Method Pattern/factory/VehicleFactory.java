package factory;

import exception.CustomException;

public class VehicleFactory {
    public Vehicle createVehicle(String type) throws CustomException {
        if (type == null || type.isEmpty()) {
            throw new CustomException("Invalid vehicle type provided.");
        }

        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                throw new CustomException("Vehicle type not supported.");
        }
    }
}
