import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Data Base");
        Scene scene = new Scene( new Menu().getMenu(), 1080,720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}