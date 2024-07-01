package client;

import factory.*;

import model.Car;
import model.Engine;
import model.Wheel;
import model.honda.HondaCivic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new factory.honda.CarFactory(); // builds the parts for the car
        CarCreator carCreator = new CarCreator(); // assembles the car
        Car myFabCar =  carCreator.create(carFactory, "HondaCivicZ");
        System.out.println(myFabCar.getModelName());







    }

}
