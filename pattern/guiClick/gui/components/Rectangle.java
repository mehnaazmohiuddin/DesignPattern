package gui.components;

import mouse.ImmutableMouseEvent;
import mouse.MouseEvent;
import util.ImmutablePair;

import java.awt.geom.Point2D;

public class Rectangle extends model.Rectangle implements Shape {
    Point2D origin;


    public Rectangle(int length, int breadth, Point2D.Double position) {
        super(length, breadth);
        this.origin = position;
        postInit();

    }

    public Rectangle(int length, int breath) {
        super(length, breath);
        origin = new Point2D.Double(0,0);
        postInit();
    }


    boolean selected;

    private void postInit() {
        processUnselected();
        this.draw();
    }

    //Highlight boundry, etc, show name etc can be done here.
    private void postSelection() {
        selected = true;
        System.out.println(" (" + origin.getX() + " , " + origin.getY() + ") Rectangle is selected");
    }

    //Remove Highlight boundry, etc, removing show name etc can be done here if was selected before.
    private void processUnselected() {
        selected = false;
    }

    @Override
    public void update(Object o) {
        if (o.getClass().equals(ImmutableMouseEvent.class)) {
            ImmutableMouseEvent e = (ImmutableMouseEvent) o;
            if (e.getEvent() == MouseEvent.CLICK) {
                handleClick(e);
            } else if (e.getEvent() == MouseEvent.DRAG) { // drag
                handleDrag(e);
            }
        }
    }

    private void handleClick(ImmutableMouseEvent e) {
        double mouseClickX = e.getPoint2D().getX();
        double mouseClickY = e.getPoint2D().getY();
        if (mouseClickX > origin.getX() && mouseClickX < (origin.getX() + this.getLength()) && mouseClickY > origin.getY() && (mouseClickY < origin.getY() + this.getBreath())) {
            postSelection();
        } else {
            processUnselected();
        }
    }

    private void handleDrag(ImmutableMouseEvent e) {
        ImmutablePair<Point2D, Point2D> pointsOfRectangeSelected = e.getPointsCaptured();
        Point2D x1y1 = pointsOfRectangeSelected.getLeft();
        Point2D x2y2 = pointsOfRectangeSelected.getRight();
        ImmutablePair<Double, Double> x1x2 = ImmutablePair.of(x1y1.getX(), x2y2.getX());
        ImmutablePair<Double, Double> y1y2 = ImmutablePair.of(x1y1.getY(), x2y2.getY());
        double Ax1 = x1x2.getLeft();
        double Ax2 = x1x2.getRight();
        double Ay1 = y1y2.getLeft();
        double Ay2 = y1y2.getRight();
        double Bx1 = origin.getX();
        double Bx2 = Bx1 + this.getLength();
        double By1 = origin.getY();
        double By2 = By1 - this.getBreath();
        if (Ax1 < Bx1) {
            // Ax1 is left
            selected = checkOverlap(Ax1, Ax2, Ay1, Ay2, Bx1, Bx2, By1, By2);
        } else {
            selected = checkOverlap(Bx1, Bx2, By1, By2, Ax1, Ax2, Ay1, Ay2);
        }
        if (selected) {
            postSelection();
        } else {
            processUnselected();
        }
    }

    private boolean checkOverlap(double ax1, double ax2, double ay1, double ay2, double bx1, double bx2, double by1, double by2) {
        // a is left.
        return (ax2 < bx2 && ax2 > bx1 && ay2 > by2 && ay2 < by1);
    }

    public boolean isSelected() {
        return selected;
    }
}
