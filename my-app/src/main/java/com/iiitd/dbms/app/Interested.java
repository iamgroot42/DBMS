package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Interested {
	String userId;
	String interest;

	public Interested( )
	{
		
	}

	public Interested( String userId, String interest)
	{
		this.userId = userId;
		this.interest = interest;
	}

	// initialiilze the DB table
	public static void initTable()
	{
		String query;
		try{
			query = "DROP TABLE Interested;";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e) {}
		try{
			query = "CREATE TABLE Interested ( userId VARCHAR(30) ,  interest VARCHAR(50) ) ;";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	// take the id and add  it .... if exists then update it 
	public void save()
	{
		String query;
		try{
			if(DMManager.execQuery("SELECT * FROM Interested WHERE userId = '" + userId + "' AND interest = '" + interest + "'").next())
			{
				query = "UPDATE Interested SET userId = '"+userId+"' , interest = '"+interest+"' WHERE userId = '"+ userId + "' AND interest = '" + interest + "'";
				DMManager.execDDLQuery( query );
			}
			else{
				query = "INSERT INTO Interested (userId, interest)  VALUES ('"+userId+"','"+interest+"')";
				DMManager.execDDLQuery( query );
			}
			return;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// try
		// {
		// 	query = "INSERT INTO Interested (userId, interest)  VALUES ('"+userId+"','"+interest+"')";
		// 	DMManager.execDDLQuery( query );
		// }
		// catch(Exception e)
		// {
		// 	e.printStackTrace();
		// }
	}

	public void delete()
	{
		try{
			String query = "DELETE FROM Interested WHERE userId = '"+ userId + "' AND interest = '" + interest + "'";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	public static ArrayList<Interested> getAll()
	{
		return getAll("");
	}

	public static ArrayList<Interested> getAll(String selector)
	{
		String query = "SELECT * FROM Interested " + selector;
		ArrayList<Interested>  r = new ArrayList<Interested>();
		try{
			ResultSet resultSet = DMManager.execQuery(query);
	        while (resultSet.next()) {
		       Interested t = new Interested();
		       t.interest = resultSet.getString(1);
		       t.userId = resultSet.getString(2);
		       r.add(t);
	    	}
		} catch(Exception e){
			 e.printStackTrace();
		}
    	return r;
	}
}
