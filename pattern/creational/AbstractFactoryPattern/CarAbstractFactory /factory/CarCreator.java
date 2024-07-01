package factory;

import model.Car;
import org.jetbrains.annotations.NotNull;

//This class knows how to create a car.
public class CarCreator {
    public @NotNull Car create(CarFactory carFactory, String modelName) throws CarNotFoundException{
          Car car =  carFactory.createCar(modelName);
          car.setWheels(carFactory.createFrontWheels());
          car.setEngine(car.getEngine());
          return car;
    }
}
