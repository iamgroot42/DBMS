package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ratings {
	int rating;
	String appId;
	String userId;

	public Ratings( )
	{
		
	}

	public Ratings( int rating, String appId, String userId)
	{
		this.rating = rating;
		this.appId = appId;
		this.userId = userId;
	}

	// initialiilze the DB table
	public static void initTable()
	{
		try{
			String query = "CREATE TABLE Ratings ( rating INT ,  appId VARCHAR(30) ,  userId VARCHAR(30) ) ;";
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
		try{
			if(DMManager.execQuery("SELECT * FROM Ratings WHERE appId = '" + appId + "' AND userId = '" + userId + "'").next())
			{
				String query = "UPDATE Ratings SET rating = '"+rating+"' , appId = '"+appId+"' , userId = '"+userId+"' WHERE appId = '"+ appId + "' AND userId = '" + userId + "'";
				DMManager.execDDLQuery( query );
			}else{
				String query = "INSERT INTO Ratings (rating, appId, userId)  VALUES ('"+rating+"','"+appId+"','"+userId+"')";
				DMManager.execDDLQuery( query );
			}
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	public void delete()
	{
		try{
			String query = "DELETE FROM User WHERE appId = "+ appId + " AND userId = " + userId;
			DMManager.execDDLQuery( query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	public static ArrayList<Ratings> getAll()
	{
		return getAll("");
	}

	public static ArrayList<Ratings> getAll(String selector)
	{

		String query = "SELECT * FROM Ratings " + selector;
		ArrayList<Ratings>  r = new ArrayList<Ratings>();
		try{
			ResultSet resultSet = DMManager.execQuery(query);
	        while (resultSet.next()) {
		       Ratings t = new Ratings();
		       t.rating = Integer.parseInt(resultSet.getString(1));
		       t.appId = resultSet.getString(2);
		       t.userId = resultSet.getString(3);
		       r.add(t);
	    	}
		} catch(Exception e){
			 e.printStackTrace();
		}

    	return r;
	}
}
