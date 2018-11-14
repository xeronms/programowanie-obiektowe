import controller.MyPanel;
import model.*;
import model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawerProgram extends JFrame {

    public static void main(String [] argv){
        DrawerProgram dp = new DrawerProgram();

        dp.setSize(450, 450);
        dp.setVisible(true);
       // dp.add(d);
        Graphics graphics = dp.getGraphics();


        MyPanel panel = new MyPanel()();
        panel.add(new Rectangle(50,80,150,150));
        //dp.update(graphics);



        dp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });


    }

}
