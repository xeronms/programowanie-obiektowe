import com.mysql.cj.util.StringUtils;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class Menu {

    private ScrollPane root = new ScrollPane();
    private TableView< Book > table = new TableView<>( );

    ObservableList< Book > books;

    // all creating menu logic
    public Menu(){
        DataBase db = new DataBase();
        //db.connect();
        db.createBooksList();
        books = db.getBooksList();

        //searching author or id
        TextField searchField = new TextField();
        searchField.setPromptText( "Search author" );
        searchField.setPrefSize(500, 20);
        searchField.setOnAction(e -> {
            String search = searchField.getText();
            table.getItems().clear();
            // SELECT *....
            if ( StringUtils.isStrictlyNumeric( search )){
                db.createBooksList("SELECT * FROM books WHERE isbn LIKE '" + search + "%'");
        }
            else {
                db.createBooksList("SELECT * FROM books WHERE author LIKE '" + search + "%'");
            }
            books = db.getBooksList();
        });

        //composition
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        //root
        root.setPadding(new Insets(20));

        createTable();
        vbox.getChildren().addAll( searchField, table);

        root.setContent( vbox );
}

    // creating table containing all data from books list
    private void createTable(){

        TableColumn< Book, String > idCol = new TableColumn<>("ID");
        TableColumn< Book, String > titleCol = new TableColumn<>("Title");
        TableColumn< Book, String > authorCol = new TableColumn<>("Author");
        TableColumn< Book, Integer > yearCol = new TableColumn<>("year");



        idCol.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        titleCol.setMinWidth(200);

        table.getColumns().addAll(idCol, titleCol, authorCol, yearCol);

        table.setItems( books );
    }

    public ScrollPane getMenu(){
        return root;
    }
}