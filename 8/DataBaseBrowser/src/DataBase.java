import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBase {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet rs = null;

    ObservableList< Book > books = FXCollections.observableArrayList();

    //
    //   creating connection
    //
    public DataBase(){
        connect();
    }

    //
    //  connecting to data base
    //
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/msienko1",
                            "msienko1","6H8YTDRpTUrwPYpT");
        }
        catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //
    //  creating books list from data base
    //
    //
    public void createBooksList(){
        createBooksList("SELECT * FROM books");
    }

    public void createBooksList( String query ){

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery( query );

            while(rs.next()){

                // adding to books list new book from data base
                books.add( new Book(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ) );
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            // handle any errors
        }
        // releasing result set
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) { } // ignore
                statement = null;
            }
        }
    }

    public ObservableList<Book> getBooksList(){
        return books;
    }

}
