package model;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(  int x, int y, int a, int b){
        super(x,y,a,b);
    }

    @Override
    public void draw(Graphics g){
        g.drawRect( this.x, this.y, this.a, this.b);
    }
}
