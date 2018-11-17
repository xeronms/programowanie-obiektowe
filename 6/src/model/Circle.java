package model;

import java.awt.*;

public class Circle extends Shape {

    private int r;

    public Circle( int x, int y, int r){
        super(x, y, r, r);
        this.r = r;
    }

    @Override
    public void draw(Graphics g){
        g.drawOval( x, y, r, r);
    }
}
