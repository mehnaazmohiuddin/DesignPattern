package client;

import factory.CarCreator;
import factory.CarFactory;
import factory.CarNotFoundException;
import model.Car;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new factory.honda.CarFactory(); // builds the parts for the car
        CarCreator carCreator = new CarCreator(); // assembles the car
        Car myFabCar = null;
        try {
            myFabCar = carCreator.create(carFactory, "HondaCivicZ");
        } catch (CarNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(myFabCar.getModelName());
        // we can simply create a mercedes car by
        carFactory = new factory.mercedes.CarFactory(); // builds the parts for the car
        carCreator = new CarCreator(); // assembles the car

        try {
            myFabCar = carCreator.create(carFactory, "HondaCivicZ");
        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
