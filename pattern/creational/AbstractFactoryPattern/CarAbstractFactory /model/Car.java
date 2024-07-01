package model;

public abstract class Car {
    public abstract Engine getEngine();
    public abstract  void setEngine(Engine engine);
    public abstract void setWheels(Wheel[] wheels);
    public abstract Wheel[] getWheels();
    public String getModelName(){
        return this.getClass().getName();
    }
}
