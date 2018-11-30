import java.sql.*;

public class DataBase {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    // connecting to data base
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

    public void listBooks(){
        try {
            connect();
            statement = connection.createStatement();
            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            resultSet = statement.executeQuery("SELECT * FROM books");
            while(resultSet.next()){
                String name = resultSet.getString(1);

                System.out.println("Uzytkownik: "+name);
            }
        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) { } // ignore
                resultSet = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) { } // ignore
                statement = null;
            }
        }
    }


}
