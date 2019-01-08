import com.sun.deploy.util.StringUtils;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Game{

    private ScrollPane root = new ScrollPane();
    //private TableView< Book > table = new TableView<>( );
    //DataBase db = new DataBase();


    //  creating whole menu logic
    public Game(){
        //  composition
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        for(int i=0; i<3; ++i) {
            for(int j=0; j<3; ++j) {
                //  searching author or id
                Text field = new Text(20, 50, "[ ]");

                //  adding new element to books db
                Button addButton = new Button("tap");
                addButton.setOnAction(e -> {
                    field.setText("[X]");
                    // ++turn counter
                });
                vbox.getChildren().addAll(field, addButton);
                //tileButtons.setHgap(10.0);
                //tileButtons.setVGap(8.0);
            }
        }


        //  root
        root.setPadding(new Insets(20));
        root.setContent( vbox );
    }

    public ScrollPane getRoot(){
        return root;
    }
}