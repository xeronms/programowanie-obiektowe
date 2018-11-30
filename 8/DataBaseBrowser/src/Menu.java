import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Menu {

    private ScrollPane root = new ScrollPane();
    private TableView< DataBase > table = new TableView<>( );

    public Menu(){
        DataBase db = new DataBase();
        db.listBooks();

        //searching author
        TextField searchField = new TextField();
        searchField.setPromptText( "Search author" );
        searchField.setPrefSize(500, 20);
        searchField.setOnAction(e -> {
            String search = searchField.getText();

            // SELECT *....

        });

        //composition
        VBox vbox = new VBox();
        vbox.getChildren().addAll( searchField, table);
        vbox.setSpacing(10);

        //root
        root.setPadding(new Insets(20));
        createTable();
        root.setContent( vbox );
}

    public ScrollPane getMenu(){
        return root;
    }

    // creating table containing all data from main
    private void createTable(){

        TableColumn< DataBase, String > idCol = new TableColumn<>("ID");

        table.getColumns().addAll(idCol);
    }
}
