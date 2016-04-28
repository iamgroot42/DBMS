package com.iiitd.dbms.app;

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
	Integer credit;

	public User( )
	{
		
	}

	public User( String name, String passwordHash, String userId , Integer credit )
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
		try
		{
			query = "DROP TABLE User";
			DMManager.execDDLQuery( query );
		}
		catch(Exception e){}
		try
		{
			query = "CREATE TABLE User (  name VARCHAR(30) ,  passwordHash VARCHAR(30) ,  userId VARCHAR(30)  , credit int  ) ;";
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
			if(DMManager.execQuery("SELECT * FROM User WHERE userId = "+ userId).next())
			{
				query = "UPDATE User SET  name = '"+name+"' , passwordHash = '"+passwordHash+"' , credit = '"+credit+"' , userId = '"+userId+"' WHERE userId = "+ userId;
				DMManager.execDDLQuery( query );
			}
			return;
		}
		catch(Exception e) {}
		try
		{
			query = "INSERT INTO User (name, passwordHash, userId , credit )  VALUES ('"+name+"','"+passwordHash+"','"+userId+"','"+credit+"')";
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
			String query = "DELETE FROM User WHERE userId = "+ userId;
			DMManager.execDDLQuery(  query );
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	public static ArrayList<User> getAll()
	{
		return getAll("");
	}

	public static User getByID(String userId )
    {
        ArrayList<User> aa =  getAll("WHERE userId = '" + userId +"'");
        
        // if( aa.size() == 0 )
        // {
        //     return NULL ;
        // }

        return aa.get(0);

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
		       t.credit = Integer.parseInt( resultSet.getString(4));
		       r.add(t);
	    	}
		} catch(Exception e){
			 e.printStackTrace();
		}
    	return r;
	}
	
}
