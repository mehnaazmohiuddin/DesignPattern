package composite_pattern_main;

import model.Circle;
import model.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle layout = new Rectangle(100,100);
        Rectangle rectangle = new Rectangle(40,10);
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(2);
        rectangle.addPicture( circle);
        rectangle.addPicture( circle2);
        circle.setParentPicture(rectangle);
        circle2.setParentPicture(rectangle);
        rectangle.setParentPicture(layout);
        layout.addPicture(rectangle);
        layout.draw();
        // add child add parent and draw. basically picture interface to draw the picture.
    }
}
