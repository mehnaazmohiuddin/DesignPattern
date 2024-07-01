package factory.mercedes;

import model.Car;
import model.Engine;
import model.Wheel;
import model.mercedes.EQT;

public class CarFactory implements factory.CarFactory {
    @Override
    public Engine createEngine() {
        return new Engine() {
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

        };
    }

    @Override
    public Wheel[] createFrontWheels() {
        return new Wheel[0];
    }

    @Override
    public Wheel[] createBackWheels() {
        return new Wheel[0];
    }

    @Override
    public Car createCar(String name) {
        return new EQT();
    }
}
