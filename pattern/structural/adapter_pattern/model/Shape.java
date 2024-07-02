package adapter_pattern.model;

import adapter_pattern.manipulators.Manipultator;

public interface Shape {
    public BoundingBox getBoundingBox();
    public Manipultator createManipulator();

}
