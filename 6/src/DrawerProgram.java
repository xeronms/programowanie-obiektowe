import controller.MyPanel;
import model.*;
import model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawerProgram extends JFrame {

    @Override
    public void paint(Graphics g){
        new Rectangle(100,100,100,100).draw( g );
    }

    public static void main(String [] argv) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new DrawerProgram());
        f.setSize(800,375);
        f.setVisible(true);
    }
}
