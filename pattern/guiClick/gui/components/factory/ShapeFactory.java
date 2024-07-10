package gui.components.factory;

import gui.components.Shape;
import gui.components.exceptions.NoShapeFoundException;

public interface ShapeFactory {
     Shape createShape(String shapeName, String size) throws NoShapeFoundException;

}
