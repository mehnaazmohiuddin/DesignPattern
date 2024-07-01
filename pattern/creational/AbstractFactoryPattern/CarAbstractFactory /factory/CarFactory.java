package factory;

import model.Car;
import model.Engine;
import model.Wheel;

public interface CarFactory {
    public Engine createEngine();
    public Wheel[] createFrontWheels();
    public Wheel[] createBackWheels();

    public Car createCar(String modelName);
}
