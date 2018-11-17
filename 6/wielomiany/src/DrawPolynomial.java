import javax.swing.*;
import java.awt.*;


class DrawPanel extends JPanel {
    private Polynomial p;
    private int width, height, start, end, step;

    DrawPanel(int w, int h, Polynomial p, int start, int end, int step){
        super();
        width = w;
        height = h;
        this.p = p;
        this.start = start;
        this.end = end;
        this.step = step;
    }

    private void paintAxis(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        g.setColor(Color.black);

        g.drawLine(0,height-2,width,height-2);
        g.drawLine(0,height-1,width,height-1);
        g.drawLine(0,height,width,height);
        g.drawLine(0,0,0,height);
        g.drawLine(1,0,1,height);
    }

    private void paintPolynomial(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;

        g.setColor(Color.blue);

        for (int x = start; x < end; x+=step){
            g.drawLine(x, height - (int)p.value(x), x+step, height - (int)p.value(x+step));
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        paintAxis(g);
        paintPolynomial(g);
    }
}


public class DrawPolynomial extends JFrame {

    public static void main(String[] args) {

        int width = 1280;
        int height = 720;
        double [] factors = {1,2,1};
        int start = 0;
        int end = 100;
        int step = 10;

        Polynomial W = new Polynomial( factors );

        DrawPolynomial frame = new DrawPolynomial();

        DrawPanel drawPanel = new DrawPanel( width, height, W, start, end, step);
        frame.add(drawPanel);

        frame.setSize(width, height);
        frame.setTitle("Points");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}