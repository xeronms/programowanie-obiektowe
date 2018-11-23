package sample;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Graph {

    Polynomial p;
    Stage window;

    public Graph( Polynomial p ){
        this.p = p;
        window = new Stage();
        window.setTitle("GRAPH");



        Scene scene = new Scene( new VBox(),800,600);

        window.setScene(scene);
        window.show();
    }


    public void display(){}
}
