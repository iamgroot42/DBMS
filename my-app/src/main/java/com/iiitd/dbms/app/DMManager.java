package com.iiitd.dbms.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DMManager{


    	static String dbUrl = "jdbc:mysql://localhost/mydatabase";
	    static String dbClass = "com.mysql.jdbc.Driver";
	    // String query = "Select distinct(table_name) from INFORMATION_SCHEMA.TABLES";
	    static String username = "root";
	    static String password = "";

	    static Statement statement;

	    static  Boolean isConnected = false;

	    // public static DMManager( String dbUrl  , String username ,   String password   )
	    // {
	    // 	this.dbUrl = dbUrl;
	    // 	this.username = username;
	    // 	this.password = password;
	    // }

	    static void connect()
	    {
	    	 try {

		        Class.forName(dbClass);
		        Connection connection = DriverManager.getConnection(dbUrl, username, password);
		        statement = connection.createStatement();

		        isConnected = true;
		     //    ResultSet resultSet = statement.executeQuery(query);

		     //    while (resultSet.next()) {
			    //     String tableName = resultSet.getString(1);
			    //     System.out.println("Table name : " + tableName);
		    	// }
		     //    connection.close();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

	    }

	    public static ResultSet execQuery( String query) throws SQLException
	    {

	    	if(!(isConnected))
	    		connect();

	    	return statement.executeQuery(  query ) ;
	    }

	    public static void execDDLQuery( String query) throws SQLException
	    {

	    	if(!(isConnected))
	    		connect();

	    	statement.executeUpdate(  query ) ;
	    }
	    

	    public static void testDB()
	    {
	    	try{
	    		ResultSet resultSet = execQuery("Select distinct(table_name) from INFORMATION_SCHEMA.TABLES");
	    		while (resultSet.next()) {
			        String tableName = resultSet.getString(1);
			        System.out.println("Table name : " + tableName);
		    	}
	    	} catch (Exception e){
	    		e.printStackTrace();
	    	}
	    }
}