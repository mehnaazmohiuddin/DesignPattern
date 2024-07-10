package mouse;

import model.Producer;
import util.ImmutablePair;

import java.awt.geom.Point2D;

public class LenovoMouse extends Producer implements mouse {
    @Override
    public ImmutableMouseEvent click(Point2D point, MouseButton button) {
        ImmutableMouseEvent immutableMouseEvent = new ImmutableMouseEvent(point, button);
        allListeners.forEach(listener -> listener.update(immutableMouseEvent));
        return immutableMouseEvent;
    }

    @Override
    public ImmutableMouseEvent drag(ImmutablePair<Point2D, Point2D> pointsCaptured) {
        ImmutableMouseEvent immutableMouseEvent =  new ImmutableMouseEvent(pointsCaptured);
        allListeners.forEach(listener -> listener.update(immutableMouseEvent));
        return immutableMouseEvent;
    }

    @Override
    public void notifyListeners() {

    }
}
