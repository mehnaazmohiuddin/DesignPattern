package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Circle extends Picture{

   int size;
    public Circle(int radius) {
        this.size = radius;

    }

    @Override
    public void draw() {
        System.out.println("drawing  circle with radius first "+size);
        drawChildren();
    }




}
