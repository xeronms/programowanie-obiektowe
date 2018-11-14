package controller;

import model.Shape;

import java.awt.*;

public class MyPanel extends Panel {

    private java.util.List<Shape> list = new java.util.ArrayList<>();

    public void add(Shape comp) {
        list.add( comp );
    }

    private void printComponent(Graphics g){
        super.printAll(g);

        for ( Shape shape : list){
            shape.draw( g );
        }
    }

}
