package mouse;

import model.Producer;
import util.ImmutablePair;

import java.awt.geom.Point2D;

// Event is a producer , from pub sub model.
public class ImmutableMouseEvent extends Producer {

    MouseButton button;
    Point2D point2D;


    MouseEvent event;

    public ImmutablePair<Point2D, Point2D> getPointsCaptured() {
        return pointsCaptured;
    }


    ImmutablePair<Point2D, Point2D> pointsCaptured;

    @Override
    public String toString() {

         if(point2D == null )
         return "ImmutableMouseEvent { " +
                 "button=" + button +
                 ", pointsCaptured are => " + pointsCaptured.getLeft().toString() + " ==== "+ pointsCaptured.getRight().toString()+
                 "}";
         else
             return "ImmutableMouseEvent { " +
                     "button=" + button +
                     ", point2D=" + point2D.toString() ;


    }

    public ImmutableMouseEvent(Point2D point2D, MouseButton button) {
        this.button = button;
        this.point2D = point2D;
        this.event = MouseEvent.CLICK;
        notifyListeners();
    }

    public ImmutableMouseEvent( ImmutablePair<Point2D, Point2D> pointsCaptured) {
        this.button = MouseButton.LEFT_BUTTON;
        this.pointsCaptured = pointsCaptured;
        this.event = MouseEvent.DRAG;
        notifyListeners();
    }


    public MouseButton getButton() {
        return button;
    }
    public  Point2D getPoint2D() {
        return point2D;
    }

    @Override
    public void notifyListeners() {
        if (allListeners !=null){
            allListeners.forEach(listener -> ( listener).update(this));
        }

        System.out.println(" Event happened "+ this.toString());
    }
    public MouseEvent getEvent() {
        return event;
    }

}
