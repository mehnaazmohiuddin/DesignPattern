package model;

import manipulators.Manipultator;

public interface Shape {
    public BoundingBox getBoundingBox();
    public Manipultator createManipulator();

}
