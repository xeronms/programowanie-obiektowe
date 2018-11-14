package model;

import java.awt.*;

public class Circle extends Shape {

    private int r;

    public Circle( int r, int x, int y){
        super(x, y);
        this.r = r;
    }

    @Override
    public void draw(Graphics graphics) {

    }
}
