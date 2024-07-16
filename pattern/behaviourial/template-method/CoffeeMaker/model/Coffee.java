package model;

import java.util.ArrayList;

public class Coffee {
    ArrayList<Object> coffeeMix;

    Coffee (ArrayList<Object> coffeeMix){
        this.coffeeMix = coffeeMix;
    }
    @Override
    public String toString(){
        return coffeeMix.toString();
    }

}
