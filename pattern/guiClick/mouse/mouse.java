package mouse;

import util.ImmutablePair;
import java.awt.geom.Point2D;

public interface mouse {
     ImmutableMouseEvent click(Point2D point, MouseButton button);
     ImmutableMouseEvent drag(ImmutablePair<Point2D, Point2D> pointsCaptured);
}
