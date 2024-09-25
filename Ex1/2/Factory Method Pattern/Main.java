import factory.VehicleFactory;
import factory.Vehicle;
import logging.Logger;
import exception.CustomException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger.log("Factory Method Pattern: Vehicle Creation");

        VehicleFactory vehicleFactory = new VehicleFactory();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create Car");
            System.out.println("2. Create Bike");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear the buffer

            switch (choice) {
                case 1:
                    try {
                        Vehicle car = vehicleFactory.createVehicle("car");
                        car.drive();
                    } catch (CustomException e) {
                        Logger.log("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Vehicle bike = vehicleFactory.createVehicle("bike");
                        bike.drive();
                    } catch (CustomException e) {
                        Logger.log("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    Logger.log("Exiting...");
                    exit = true;
                    break;
                default:
                    Logger.log("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
