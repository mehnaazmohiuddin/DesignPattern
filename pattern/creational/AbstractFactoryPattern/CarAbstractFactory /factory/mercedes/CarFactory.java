package factory.mercedes;

import factory.CarNotFoundException;
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
    public Car createCar(String name) throws CarNotFoundException{
        if (name.equals("EQT"))
            return new EQT();
        else {
            throw new  CarNotFoundException("No Car with model name "+name +" can be built in the mercedes facrtory");
        }
    }
}
