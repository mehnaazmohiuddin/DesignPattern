package model;
public class Rectangle extends Picture{

    int length;
    int breath;

    public Rectangle(int length, int breath) {
        this.length = length;
        this.breath = breath;
    }

    @Override
    public void draw() {
        System.out.println("drawing rectangle first "+length + breath);
        drawChildren();
    }



}
