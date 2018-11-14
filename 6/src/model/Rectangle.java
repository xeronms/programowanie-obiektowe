package model;

import java.awt.*;

public class Rectangle extends Shape {

    int a;
    int b;

    public Rectangle( int a, int b, int x, int y){
        super(x,y);
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;
        g.drawRect( this.x, this.y, this.a, this.b);
    }
}
