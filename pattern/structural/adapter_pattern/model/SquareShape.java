package adapter_pattern.model;

import adapter_pattern.manipulators.Manipultator;

public class SquareShape implements Shape {
    @Override
    public BoundingBox getBoundingBox() {
        return null;
    }

    @Override
    public Manipultator createManipulator() {
        return null;
    }
}
