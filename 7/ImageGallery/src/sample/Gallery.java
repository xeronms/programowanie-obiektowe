package sample;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

public class Gallery {


    public static ScrollPane createGallery(){

        ScrollPane scroll = new ScrollPane();
        TilePane tile = new TilePane();

        TextField path = new TextField();
        path.setPromptText( "Enter gallery path" );
        path.setMaxSize(500,50);


        tile.getChildren().addAll(path);

        scroll.setContent(tile);

        return scroll;
    }
}
