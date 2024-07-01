package model.honda;

import model.Car;
import model.Engine;
import model.Wheel;

public class HondaCivic extends Car {
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

    @Override
    public String getModelName() {
        return this.getClass().getName();
    }
}
