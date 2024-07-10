package main;

import gui.components.Rectangle;
import gui.components.Shape;
import gui.components.exceptions.NoShapeFoundException;
import gui.components.factory.ShapeFactory;
import gui.components.factory.SimpleShapeFactory;
import mouse.LenovoMouse;
import mouse.MouseButton;
import util.ImmutablePair;

import java.awt.geom.Point2D;

public class Main {
    public static void main(String[] args) throws NoShapeFoundException {
        ShapeFactory shapeFactory = new SimpleShapeFactory();
        Shape rectangle1 =  shapeFactory.createShape("Rectangle","100,100");
        Rectangle rectangle = new Rectangle(10, 10, new Point2D.Double(29,20));
        LenovoMouse mouse = new LenovoMouse();
        mouse.addListener(rectangle);
        mouse.addListener(rectangle1); // i had to explicity cast this to be used as a listener here.
        mouse.click(new Point2D.Double(29,26), MouseButton.LEFT_BUTTON);
        mouse.click(new Point2D.Double(100,100), MouseButton.LEFT_BUTTON);
        mouse.drag( ImmutablePair.of(new Point2D.Double(55,40), new Point2D.Double(57,18)));
    }
}
