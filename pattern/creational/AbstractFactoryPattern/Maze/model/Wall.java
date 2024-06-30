package model;

import exceptions.MazeBoundryException;
import model.Boundry;

public class Wall implements Boundry {
    @Override
    public void enter(Character enter) throws MazeBoundryException {
        throw new MazeBoundryException("This is a wall cant enter");
    }
}
