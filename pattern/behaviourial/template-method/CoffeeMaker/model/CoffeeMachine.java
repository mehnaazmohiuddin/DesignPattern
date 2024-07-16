package model;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeMachine extends CoffeeMaker {

    Object groundedCoffee; // for time constraints dint make them as special types.
    Object milk;
    Object sugar;

    @Override
    public void doOpen() {
        System.out.println("Starting machine");

    }

    @Override
    public void doClose() {
        System.out.println("Closing machine");

    }

    @Override
    public Coffee doPourCoffee() {
        System.out.println("Pouring Coffee");
        return new Coffee(new ArrayList<>(Arrays.asList(groundedCoffee, milk, sugar)));
    }

    @Override
    public void doAddIngredient() {
        groundedCoffee = new Object();
        milk = new Object();
        sugar = new Object();

    }
}
