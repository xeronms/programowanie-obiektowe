package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Gallery {
    private static ScrollPane scroll;
    private static TilePane tile;

    public static ScrollPane createGallery(){

        // Screen
        scroll = new ScrollPane();
        tile = new TilePane();

        // Path
        TextField pathField = new TextField();
        pathField.setPromptText( "Enter gallery path" );
        pathField.setMaxSize(500,50);

        Button button = new Button("Load");
        button.setOnAction(e -> {
            fileLoad( pathField );
        });

        tile.getChildren().addAll( pathField, button );

        scroll.setContent(tile);

        return scroll;
    }

    private static void fileLoad( TextField pathField ){
        if ( pathField.getText()!=null && !pathField.getText().isEmpty()){
            final String path = pathField.toString();

            File file = new File(path);
            File [] photos = file.listFiles();

            try {
                for (File photo : photos) {

                    ImageView imageView = createImage(photo);
                }
            }
            catch ( NullPointerException|FileNotFoundException e){
                e.fillInStackTrace();
            }
        }
    }

    private static ImageView createImage( File file ) throws FileNotFoundException {

        final Image image = new Image(new FileInputStream( file ), 200, 0, true, true);
        ImageView imageView = null;
        imageView = new javafx.scene.image.ImageView(image);
        imageView.setFitWidth(200);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        BorderPane borderPane = new BorderPane();
                        ImageView imageView = new ImageView();
                        Image image = new Image(new FileInputStream(file));
                        imageView.setImage(image);
                        imageView.setStyle("-fx-background-color: BLACK");
                        imageView.setFitHeight(600);
                        imageView.setPreserveRatio(true);
                        imageView.setSmooth(true);
                        imageView.setCache(true);
                        borderPane.setCenter(imageView);
                        borderPane.setStyle("-fx-background-color: BLACK");
                        Stage newStage = new Stage();
                        newStage.setWidth(600);
                        newStage.setHeight(600);
                        newStage.setTitle(file.getName());
                        Scene scene = new Scene(borderPane, Color.BLACK);
                        newStage.setScene(scene);
                        newStage.show();
                    }
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        });

        return imageView;
    }
}
