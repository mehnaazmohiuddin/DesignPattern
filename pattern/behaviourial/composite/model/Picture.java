package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Picture{
    public abstract void draw();
    protected void drawChildren(){
        if(children != null)
            for (Picture p : children){
                System.out.println("drawing  this next");
                p.draw();
            }
    }
    List<Picture> children;
    Picture parentPicture;
    public List<Picture> getAllPictures() {
        return children;
    }

    public Picture getParentPicture() {
        return parentPicture;
    }

    public void setParentPicture(Picture parent) {
        parentPicture = parent;
    }

    public void addPicture(Picture child) {
        //ofNullable gives EMPTY  if null, now orElse checks null and gives 'other value'  here its new arraylist
        children =   Optional.ofNullable(children).orElse(new ArrayList<>());
        children.add(child);
    }

    public void removePicture(Picture child) {
        if(children == null)
            return;
        children.removeIf( element -> element.equals(child));
    }

}
