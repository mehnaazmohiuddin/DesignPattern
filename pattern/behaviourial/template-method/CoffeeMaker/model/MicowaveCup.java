package model;

import java.util.ArrayList;
import java.util.Arrays;

public class MicowaveCup implements Cup {
    ArrayList<Object> cupObjects ;

    public MicowaveCup() {
        cupObjects = new ArrayList<>();
    }


    @Override
    public void fill(Object object) {
        cupObjects = new ArrayList<>(Arrays.asList(object)) ;
    }

    public void add(Object object) {
        cupObjects.add(object);
    }

    @Override
    public Object pour() {
        return new Coffee(cupObjects);
    }



}
