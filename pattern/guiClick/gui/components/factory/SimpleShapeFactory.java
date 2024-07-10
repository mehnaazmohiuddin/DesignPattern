package gui.components.factory;

import gui.components.Rectangle;
import gui.components.Shape;
import gui.components.exceptions.NoShapeFoundException;

import java.util.Arrays;
import java.util.List;

public class SimpleShapeFactory implements  ShapeFactory{
    @Override
    public Shape createShape(String shapeName, String size) throws NoShapeFoundException {
        switch (shapeName) {
            case "Rectangle" -> {
                try {
                    List<Integer> ints = Arrays.stream(size.split(","))
                            .map(Integer::parseInt)
                            .toList();
                    return new Rectangle(ints.get(0), ints.get(1));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoShapeFoundException("Rectangle size should be 2, size given is " + size);
                }
            }
            default -> throw new NoShapeFoundException(shapeName + " shape not found");
        }
    }
}
