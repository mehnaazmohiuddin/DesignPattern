package model.honda;

import model.Car;
import model.Engine;
import model.Wheel;

public class HondaCivicZ extends Car {
    @Override
    public Engine getEngine() {
        return null;
    }

    @Override
    public void setEngine(Engine engine) {

    }

    @Override
    public void setWheels(Wheel[] wheels) {

    }

    @Override
    public Wheel[] getWheels() {
        return new Wheel[0];
    }
}
