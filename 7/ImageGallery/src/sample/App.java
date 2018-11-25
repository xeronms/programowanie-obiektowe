package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage){

        Scene scene = new Scene( Gallery.createGallery(), 800, 500);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String [] args){
        launch(args);
    }
}
