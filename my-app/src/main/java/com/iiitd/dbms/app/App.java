package com.iiitd.dbms.app;

import static spark.Spark.*;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */


class DMManager{


    	String dbUrl = "jdbc:mysql://localhost/mydatabase";
	    String dbClass = "com.mysql.jdbc.Driver";
	    // String query = "Select distinct(table_name) from INFORMATION_SCHEMA.TABLES";
	    String username = "root";
	    String password = "";

	    DMManager( String dbUrl  , String username ,   String password   )
	    {
	    	this.dbUrl = dbUrl;
	    	this.username = username;
	    	this.password = password;
	    }


}

class User extends DMManager{
	String name;
	String passwordHash;
	String userId;

	// initialiilze the DB table
	public static void initTable()
	{

	}

	// take the id and add  it .... if exists then uddate it 
	public void save()
	{

	}

	public void delete()
	{

	}

	public static ArrayList<User> getAll()
	{

	}


}


public class App 
{
	// start spark server
    public static void main(String[] args) {

    	String dbUrl = "jdbc:mysql://localhost/mydatabase";
	    String dbClass = "com.mysql.jdbc.Driver";
	    String query = "Select distinct(table_name) from INFORMATION_SCHEMA.TABLES";
	    String username = "root";
	    String password = "";

	     try {

	        Class.forName(dbClass);
	        Connection connection = DriverManager.getConnection(dbUrl,
	            username, password);
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
		        String tableName = resultSet.getString(1);
		        System.out.println("Table name : " + tableName);
	    	}
	        connection.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }



        get("/hello", (req, res) -> "Hello World");
    }
}




