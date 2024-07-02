package model;

import externalProject.TextEdit;
import externalProject.TextEditImpl;
import manipulators.Manipultator;
import model.BoundingBox;
import model.Shape;


//This is the Adapter
public class TextShape implements Shape {

    private  TextEdit textEdit;

    public TextShape(){
        this.textEdit = new TextEditImpl();
    }

    @Override
    public BoundingBox getBoundingBox() {
        return (BoundingBox) textEdit.getExtent();
    }

    @Override
    public Manipultator createManipulator() {
        return null;
    }
}
