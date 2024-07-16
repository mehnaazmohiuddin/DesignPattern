package model;

public class CoffeeInMicrowave extends CoffeeMaker {
    MicowaveCup cup;

    public CoffeeInMicrowave(MicowaveCup cup) {
        this.cup = cup;
    }

    @Override
    public void doOpen() {
        System.out.println("Opening the door");
    }

    @Override
    public void doClose() {
        System.out.println("Closing  the door");
    }

    @Override
    public Coffee doPourCoffee() {
        System.out.println("nothing to pour, coffee is in cup");
        return  (Coffee) cup.pour();
    }

    @Override
    public void doAddIngredient() {
        cup.add("water");
        cup.add("coffee powder");
        cup.add("sugar");

    }
}
