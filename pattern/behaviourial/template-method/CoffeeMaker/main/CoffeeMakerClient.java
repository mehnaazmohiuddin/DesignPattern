package main;

import model.*;

public class CoffeeMakerClient {

    public static void main(String[] args) {

        CoffeeMaker coffeeMaker = new CoffeeInMicrowave(new MicowaveCup());
        Coffee c = coffeeMaker.makeCoffee();
        System.out.println("Here is your coffee" + c.toString());

        coffeeMaker = new CoffeeMachine();
        c = coffeeMaker.makeCoffee();
        System.out.println("Here is your coffee" + c.toString());


    }
}
