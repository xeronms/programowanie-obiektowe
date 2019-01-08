import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBase {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet rs = null;
    Connector connector;

    private int i = 0;

    //   creating connection
    public DataBase(){
        connector = new Connector();
        connector.run();
    }

    private class Connector implements Runnable, AutoCloseable{

        @Override
        public void run(){
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection =
                        DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/msienko2",
                                "msienko2","KZCkuTX6d5VuHLg7");
            }
            catch (SQLException e){
                reconnect(e);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }


        @Override
        public void close(){
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


    public synchronized void addResult( Date date, int x, int o, int points){
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO punkty VALUES ("+
                            "'"+date+"'"+","+
                            "'"+x+"'"+","+
                            "'"+o+"'"+","+
                            "'"+points+"'"+
                            ")"
            );
        } catch (SQLException ex){
            reconnect( ex );
            // handle any errors
        } finally {
            connector.close();
        }
    }




    //  reconnecting to server in case of lost connection exception
    private void reconnect( SQLException e){
        if ( i < 3){
            ++i;
            connector.run();
        }
        else{
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}