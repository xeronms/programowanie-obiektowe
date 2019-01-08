import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Library Data Base");

        Game game= new Game();
        Scene scene = new Scene( game.getRoot());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}