package sample;

import java.sql.*;

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
        String query = "select COUNT(*) from states";
        int flag = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String count = rs.getString("COUNT(*)");
                flag = Integer.parseInt(count);
            }

            if (flag > 0) {
                query = "DELETE FROM states";
                PreparedStatement prpd = conn.prepareStatement(query);
                prpd.execute();
                System.out.println("DELETED");
            }
            query = "INSERT INTO states (state)" + " values(?)";
            PreparedStatement prpd = conn.prepareStatement(query);
            prpd.setString(1, grid);
            prpd.execute();
            System.out.println("EXECUTED STATEMENT");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        }
    }

    @Override
    public String getGrid() {
        String query = "select * from states";
        String data = "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data = rs.getString("states");
            }
            return data;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "";
    }
}
