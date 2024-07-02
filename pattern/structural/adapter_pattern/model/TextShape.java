package adapter_pattern.model;

import adapter_pattern.externalProject.TextEditImpl;
import adapter_pattern.manipulators.Manipultator;
import adapter_pattern.externalProject.TextEdit;


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
