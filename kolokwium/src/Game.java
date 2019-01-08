import com.sun.deploy.util.StringUtils;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Date;


public class Game{

    private ScrollPane root = new ScrollPane();
    int x = 0;
    int o = 0;
    int turnCounter = 0;
    //private TableView< Book > table = new TableView<>( );
    //DataBase db = new DataBase();


    public Game() {
        root.setPrefSize(800, 600);
        TilePane tile = new TilePane();

        tile.setHgap(10.0);
        tile.setPrefRows(3);
        tile.setPrefColumns(3);
        tile.setOrientation(Orientation.HORIZONTAL);

        for (int i = 0; i < 3; ++i) {
            tile.setVgap(50.0);
            for (int j = 0; j < 3; ++j) {
                Text field = new Text(20, 50, "[ ]");


                Button Xbutton = new Button("X");
                Xbutton.setOnAction(e -> {
                    field.setText("[X]");
                    ++x;
                    ++turnCounter;
                });
                Button Obutton = new Button("O");
                Obutton.setOnAction(e -> {
                    field.setText("[O]");
                    ++o;
                    ++turnCounter;
                });
                tile.getChildren().addAll(field, Xbutton, Obutton);

                tile.setVgap(5.0);
            }
        }

        Button connectionButton = new Button("Submit result");
        connectionButton.setOnAction(e -> {
            DataBase db = new DataBase();
            db.addResult( new Date(2018,10,5), x, o, turnCounter);
        });

        tile.getChildren().addAll(connectionButton);
        //  root
        root.setPadding(new Insets(20));
        root.setContent(tile);
    }

    public ScrollPane getRoot(){
        return root;
    }
}