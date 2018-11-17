package model;

import java.awt.*;

public abstract class Shape{

    //* x and y coordinates
    protected int x, y;
    protected int a, b;

    public Shape(  int x, int y, int a, int b){
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public void setX( int x){
        this.x = x;
    }
    public void setY( int y){
        this.y = y;
    }
    public abstract void draw( Graphics graphics);
}