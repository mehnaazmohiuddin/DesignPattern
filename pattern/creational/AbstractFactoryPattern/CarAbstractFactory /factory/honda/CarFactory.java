package factory.honda;

import model.Car;
import model.Engine;
import model.Wheel;
import model.honda.HondaCivic;
import model.honda.HondaCivicZ;

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

    // we can paramterize this to create whatever type of honda car we want.


    // this is factory method pattern
    @Override
    public Car createCar(String carName) {

        if(carName.equals("HondaCivic"))
        return new HondaCivic();
        else
            return new HondaCivicZ();
    }
}
