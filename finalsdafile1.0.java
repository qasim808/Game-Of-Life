package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.StringJoiner;

import javax.sql.StatementEvent;

import java.sql.*;

public class Database
{
    public void LoadState(String GridID)
    {
		int[][] coordiates = new int[2][]; // includes coordiates where cell is alive.
		
        try
        {

            String url = "jdbc:mysql://localhost:3306/johngameSDAproject"; //connection string here test is the name of the database
            Connection con = DriverManager.getConnection(url, "root", "123123"); // pass the connection string, username and password
            System.out.println(con);
            System.out.println("connected");
            Statement one=con.createStatement();

            String query= "call LoadS ('" + GridID + "');";

            ResultSet rs= one.executeQuery(query);
			
			
			int count=0;
			int isAlive=0;
			
            while(rs.next())
            {
				isAlive=integer.parseInt(rs.getString(5));
				
				if(isAlive==1)
				{
					coordiates[0][count]=integer.parseInt(rs.getString(1));
					coordiates[1][count]=integer.parseInt(rs.getString(2));
					count++;
					aliveCount++;
				}
            }
            con.close();
        }
        catch (SQLException e )
        {
            System.out.println(e);
        }
		
		return coordiates;
    }

    public String viewStates()
    {
        String output=null;
        try
        {

            String url = "jdbc:mysql://localhost:3306/johngameSDAproject"; //connection string here test is the name of the database
            Connection con = DriverManager.getConnection(url, "root", "123123"); // pass the connection string, username and password
            System.out.println(con);
            System.out.println("connected");
            Statement one=con.createStatement();
            String query="call ViewState;";
            ResultSet rs= one.executeQuery(query);

            int i=0;

            while(rs.next())
            {
                if(i==0)
                {
                    output=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"\n";
                }
                else
                {
                    output=output+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"\n";
                }

                i++;
            }

            con.close();
        }
        catch (SQLException e )
        {
            System.out.println(e);
        }
        return output;
    }

    public void deleteState(String GridID)
    {
        try
        {

            String url = "jdbc:mysql://localhost:3306/johngameSDAproject"; //connection string here test is the name of the database
            Connection con = DriverManager.getConnection(url, "root", "123123"); // pass the connection string, username and password
            System.out.println(con);
            System.out.println("connected");
            Statement one=con.createStatement();

            String query="call DeleteS('" + GridID + "')";
            one.executeQuery(query);
            con.close();


        }
        catch (SQLException e )
        {
            System.out.println(e);
        }

    }

    public void saveState(String GridID, int MaxRow, int MaxCol, int[][] coordinates)
    {
        try
        {

            String url = "jdbc:mysql://localhost:3306/johngameSDAproject"; //connection string here test is the name of the database
            Connection con = DriverManager.getConnection(url, "root", "123123"); // pass the connection string, username and password
            System.out.println(con);
            System.out.println("connected");
            Statement one=con.createStatement();
			
			String query ="";
			
			for(int count=0; count<coordinates[0].length; count++)
			{
				query = "call SaveS('" + GridID + ", " + coordinates[1][count] + ", " + coordiates[0][count] + ", " + MaxCol + ", " + MaxRow + ", " + "1";
				one.executeQuery(query);
			}

            con.close();
        }
        catch (SQLException e )
        {
            System.out.println(e);
        }
    }
    public static void main(String [] arg)
    {

     /*  try {
           // Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/johngameSDAproject"; //connection string here test is the name of the database
            Connection con = DriverManager.getConnection(url, "root", "123123"); // pass the connection string, username and password
            System.out.println(con);
            System.out.println("connected");
            Statement one=con.createStatement();
            String query="call saveState ('New',4,2,1);";
           ResultSet rs= one.executeQuery(query);
            con.close();



        } catch (SQLException e ){
            System.out.println(e);
        }  */

        // DatabaseHandle one=new DatabaseHandle();
        //one.LoadState("New");
        Database one=new Database();
        //one.LoadState("New");

        //String temp=one.viewStates();
        // System.out.println(temp);

        //one.deleteState("Newtest");
        one.saveState("Newtest",9,2,true);
    }
}