package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Picture{
    public abstract void draw();
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
        System.out.println("Coming to add this chid =>"+child.getClass().getName());
        //ofNullable gives EMPTY  if null, now orElse checks null and gives 'other value'  here its new arraylist
        children =   Optional.ofNullable(children).orElse(new ArrayList<>());
        children.add(child);

        System.out.println(children.size());
    }

    public void removePicture(Picture child) {
        if(children == null)
            return;
        children.removeIf( element -> element.equals(child));
    }

}
