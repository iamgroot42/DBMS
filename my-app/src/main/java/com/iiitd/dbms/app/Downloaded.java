package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Downloaded {
	String userId;
	String appId;

	public Downloaded( )
	{
		
	}

	public Downloaded( String userId, String appId)
	{
		this.userId = userId;
		this.appId = appId;
	}

	// initialiilze the DB table
	public static void initTable()
	{
		String query;
		try
		{
			query = "DROP TABLE Downloaded;";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e) {}
		try
		{
			query = "CREATE TABLE Downloaded ( userId VARCHAR(30) ,  appId VARCHAR(30) ) ;";
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
		try
		{
			if(DMManager.execQuery("SELECT * FROM Downloaded WHERE userId = '" + userId + "' AND appId = '" + appId + "'").next())
			{
				query = "UPDATE Downloaded SET userId = '"+userId+"' , appId = '"+appId+"' WHERE userId = '"+ userId + "' AND appId = '" + appId + "'";
				DMManager.execDDLQuery( query );
			}
			else{
				query = "INSERT INTO Downloaded (userId, appId)  VALUES ('"+userId+"','"+appId+"')";
				DMManager.execDDLQuery( query );
			}
			return;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// try
		// {
		// 	query = "INSERT INTO Downloaded (userId, appId)  VALUES ('"+userId+"','"+appId+"')";
		// 	DMManager.execDDLQuery( query );
		// }
		// catch(Exception e)
		// {
		// 	 e.printStackTrace();
		// }
	}

	public void delete()
	{
		try{
			String query = "DELETE FROM Downloaded WHERE userId = "+ userId + " AND appId = " + appId;
			DMManager.execDDLQuery( query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	public static ArrayList<Downloaded> getAll()
	{
		return getAll("");
	}

	public static ArrayList<Downloaded> getAll(String selector)
	{
		String query = "SELECT * FROM Downloaded " + selector;
		ArrayList<Downloaded>  r = new ArrayList<Downloaded>();
		try{
			ResultSet resultSet = DMManager.execQuery(query);
	        while (resultSet.next()) {
		       Downloaded t = new Downloaded();
		       t.appId = resultSet.getString(1);
		       t.userId = resultSet.getString(2);
		       r.add(t);
	    	}
		} catch(Exception e){
			 e.printStackTrace();
		}
    	return r;
	}
}
