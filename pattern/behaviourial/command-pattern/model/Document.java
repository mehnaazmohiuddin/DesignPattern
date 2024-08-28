package model;

public interface Document<T> {
     T getSelectedObject();
     void addObject( T object);
}
