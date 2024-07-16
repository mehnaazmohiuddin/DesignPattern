package model;

public abstract  class CoffeeMaker {
    public abstract  void doOpen();
    public abstract void doClose();
    public abstract Coffee doPourCoffee();

    public abstract void doAddIngredient();
    public Coffee makeCoffee(){
        doOpen();
        doAddIngredient();
        Coffee coffee =   doPourCoffee();
        doClose();
        return coffee;
    }

}
