package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDBLayer implements IDBSQL{
    private String dbURL;
    private Connection conn;
    public SQLDBLayer(){
        dbURL = "jdbc:mysql://localhost:3306/test"; //connection string here test is the name of the database
        try {
            conn = DriverManager.getConnection(dbURL, "root", "");
            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
         }
    }
    @Override
    public void saveGrid(String grid) {
        //store the string
    }

    @Override
    public String getGrid() {
        //
        return "";
    }
}
