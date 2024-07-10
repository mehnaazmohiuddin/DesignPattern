package model;
public class Rectangle extends Picture{

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreath() {
        return breath;
    }

    public void setBreath(int breath) {
        this.breath = breath;
    }

    int length;
    int breath;

    public Rectangle(int length, int breath) {
        this.length = length;
        this.breath = breath;
    }

    @Override
    public void draw() {
        System.out.println("drawing rectangle first of size "+length + breath);
        drawChildren();
    }



}
