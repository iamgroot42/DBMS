package com.iiitd.dbms.app;

import static spark.Spark.*;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class User {
	String name;
	String passwordHash;
	String userId;

	public User( )
	{
		
	}

	public User( String name, String passwordHash, String userId)
	{
		this.name = name;
		this.passwordHash = passwordHash;
		this.userId = userId;
	}

	// initialiilze the DB table
	public static void initTable()
	{
		try{
			String query = "CREATE TABLE User (  name VARCHAR(30) ,  passwordHash VARCHAR(30) ,  userId VARCHAR(30) ) ;";
			DMManager.execDDLQuery(  query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	
	}



	// // take the id and add  it .... if exists then uddate it 
	public void save()
	{
		try{
			String query = "INSERT INTO User (name, passwordHash, userId)  VALUES ('"+name+"','"+passwordHash+"','"+userId+"')";
			DMManager.execDDLQuery(  query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	public void delete()
	{

	}

	public static ArrayList<User> getAll()
	{
		return getAll("");
	}

	public static ArrayList<User> getAll(String selector)
	{

		String query = "SELECT * FROM User " + selector;
		ArrayList<User>  r = new ArrayList<User>();

		try{
			ResultSet resultSet = DMManager.execQuery(query);
	   
	        while (resultSet.next()) {
		       User t = new User();
		       t.name = resultSet.getString(1);
		       t.passwordHash = resultSet.getString(2);
		       t.userId = resultSet.getString(3);
		       r.add(t);
	    	}
		} catch(Exception e){
			 e.printStackTrace();
		}

    	return r;
	}


}

