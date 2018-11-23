package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Graph {

    Polynomial p;
    int start,end,step;

    public Graph( Polynomial p, String start, String end, String step){
        this.p = p;
        this.start = Integer.parseInt(start);
        this.end = Integer.parseInt(end);
        this.step = Integer.parseInt(step);
    }

    public void display(){

        Stage window = new Stage();
        window.setTitle("GRAPH");


        Group root = new Group();
        Canvas canvas = new Canvas(900, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        draw(gc);

        root.getChildren().add(canvas);
        window.setScene(new Scene(root));
        window.show();
    }

    private void draw(GraphicsContext g){

        g.strokeLine(40, 10, 10, 40);

        for ( int x = start; x < end; x+=step){
            g.strokeLine(x, Main.height - (int)p.value(x), x+step, Main.height - (int)p.value(x+step));
        }
    }
}