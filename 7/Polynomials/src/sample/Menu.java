package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    public static VBox getMenu(){
        ArrayList<Double> factors = new ArrayList<>();
        AtomicInteger i = new AtomicInteger();

        // Title Labels
        final Label label1 = new Label("POLYNOMIALS");
        Label label2 = new Label("Give factor for: x^"+i);

        // Text Field for factors
        final TextField text1 = new TextField();
        text1.setPromptText( "Enter the factor" );

        // Button
        Button button1 = new Button();
        button1.setText("OK");
        button1.setOnAction(e -> {
            if ( text1.getText()!=null && !text1.getText().isEmpty()) {
                factors.add(new Double(text1.getText()));
                i.incrementAndGet();
                label2.setText("Give factor for: x^"+i);
                text1.clear();
            }});

        // Button 2
        Button button2 = new Button();
        button2.setText("Apply");
        button2.setOnAction(e -> {
            Graph graph = new Graph( new Polynomial( factors ));
            graph.display();
        });

        // VBOX
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll( label1, label2, text1, button1, button2);
        layout1.setAlignment(Pos.CENTER);

        return layout1;
    }
}
