package controller;

import model.Shape;

import java.awt.*;

public class MyPanel extends Panel {

    java.util.List<Shape> list;

    public void add(Shape comp) {
        list.add( comp );
    }

    public void printAll(Graphics g){
        super.printAll(g);

        for ( Shape shape : list){
            shape.draw( g );
        }
    }
}
