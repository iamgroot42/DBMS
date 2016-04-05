package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Developer {
	String name;
	String passwordHash;
	String userId;
	Integer credit;

	public Developer( )
	{
		
	}

	public Developer( String name, String passwordHash, String userId , Integer credit )
	{
		this.name = name;
		this.passwordHash = passwordHash;
		this.userId = userId;
		this.credit = credit;
	}

	// initialiilze the DB table
	public static void initTable()
	{
		String query;
		try{
			query = "DROP TABLE Developer;";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e) {}
		try
		{
			query = "CREATE TABLE Developer (  name VARCHAR(30) ,  passwordHash VARCHAR(30) ,  userId VARCHAR(30)  , credit int  ) ;";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	// // take the id and add  it .... if exists then uddate it 
	public void save()
	{
		String query;
		try{
			if(DMManager.execQuery("SELECT * FROM Developer WHERE userId = "+ userId).next())
			{
				query = "UPDATE Developer SET  name = '"+name+"' , passwordHash = '"+passwordHash+"' , credit = '"+credit+"' , userId = '"+userId+"' WHERE userId = "+ userId;
				DMManager.execDDLQuery( query );
			}
		}
		catch(Exception e) {}
		try
		{
			query = "INSERT INTO Developer (name, passwordHash, userId , credit )  VALUES ('"+name+"','"+passwordHash+"','"+userId+"','"+credit+"')";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void delete()
	{
		try{
			String query = "DELETE FROM Developer WHERE userId = "+ userId;
			DMManager.execDDLQuery(  query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	public static ArrayList<Developer> getAll()
	{
		return getAll("");
	}

	public static ArrayList<Developer> getAll(String selector)
	{

		String query = "SELECT * FROM Developer " + selector;
		ArrayList<Developer>  r = new ArrayList<Developer>();

		try{
			ResultSet resultSet = DMManager.execQuery(query);
	   
	        while (resultSet.next()) {
		       Developer t = new Developer();
		       t.name = resultSet.getString(1);
		       t.passwordHash = resultSet.getString(2);
		       t.userId = resultSet.getString(3);
		       t.credit = Integer.parseInt( resultSet.getString(4));
		       r.add(t);
	    	}
		} catch(Exception e){
			 e.printStackTrace();
		}

    	return r;
	}


}

