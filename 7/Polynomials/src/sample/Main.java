package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ArrayList<Double> factors = new ArrayList<>();

        // Title Label
        final Label label = new Label("POLYNOMIALS");

        // Text Field for factors
        final TextField text1 = new TextField();
        text1.setPromptText( "Enter factors of Polynomial" );

        // Button
        Button button1 = new Button();
        button1.setText("OK");
        button1.setOnAction(e -> {
            if ( text1.getText()!=null && !text1.getText().isEmpty()) {
                factors.add(new Double(text1.getText()));
                text1.clear();
            }});

        // VBOX
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(text1, button1, label);
        layout1.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout1, 500, 350);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene( scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
