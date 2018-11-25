package sample;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

import java.io.File;

public class Gallery {


    public static ScrollPane createGallery(){

        // Screen
        ScrollPane scroll = new ScrollPane();
        TilePane tile = new TilePane();

        // Path
        TextField pathField = new TextField();
        pathField.setPromptText( "Enter gallery path" );
        pathField.setMaxSize(500,50);

        Button button = new Button("Load");
        button.setOnAction(e -> {
            fileLoad( pathField );
        });

        tile.getChildren().addAll( pathField );

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

                }
            }
            catch (NullPointerException e){
                e.fillInStackTrace();
            }
        }
    }
}
