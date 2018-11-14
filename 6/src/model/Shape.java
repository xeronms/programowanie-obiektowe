package model;

import java.awt.*;

public abstract class Shape{

    //* x and y coordinates
    int x, y;

    Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void draw( Graphics graphics);
}