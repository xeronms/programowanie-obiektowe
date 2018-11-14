import controller.MyPanel;
import model.*;
import model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawerProgram {


    public static void main(String [] argv) {

        MyPanel myPanel = new MyPanel();

        myPanel.add( new Rectangle(100,100,100,170));
        myPanel.add( new Rectangle(600,300,50,70));
        myPanel.add( new Circle(400,400,240));;
        myPanel.add( new Circle(850,450,100));
        myPanel.add( new Square(850,500,100));

        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,760));
        frame.getContentPane().add(myPanel);
        frame.setContentPane(myPanel);
        frame.setLocationByPlatform(true);

        frame.setVisible(true);

        frame.pack();
    }
}
