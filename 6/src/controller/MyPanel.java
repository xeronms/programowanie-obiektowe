package controller;

import model.Shape;

import java.awt.*;
import java.util.LinkedList;


public class MyPanel extends Panel {

    private LinkedList<Shape> list = new LinkedList<>();

    public void add(Shape comp) {
        list.add( comp );
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        for ( Shape shape : list){
            shape.draw( g );
        }
    }



    LinkedList<Shape> getList(){
        return list;
    }


}
