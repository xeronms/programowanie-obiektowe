package controller;

import model.Shape;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class MyListener implements MouseMotionListener {

    private MyPanel panel;
    private int mousePosX;
    private int mousePosY;

    public MyListener(MyPanel myPanel){
        super();
        this.panel = myPanel;
    }


    public void mouseDragged(MouseEvent e) {
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPP");
        int dx = e.getX() - mousePosX;
        int dy =  e.getY() - mousePosY;

        Shape s = getShape(e.getX(),e.getY());

        s.setX(s.getX() + dx);
        s.setY(s.getY() + dy);

        panel.getList().remove(s);
        panel.getList().add(0, s);

        panel.repaint();


        mousePosX = e.getX();
        mousePosY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e)  {
        mousePosX = e.getX();
        mousePosY = e.getY();
    }



    private model.Shape getShape(int x, int y){
        model.Shape s = null;
        for ( Shape shape : panel.getList() ){
            if ( x >= shape.getX()-shape.getA()
                    && x <= shape.getA()+shape.getX()
                    && y >= shape.getY()-shape.getB()
                    && y <= shape.getB()+shape.getY()
            ){
                s = shape;
            }
        }

        return s;
    }


}