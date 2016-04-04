package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Category {
	String categoryId;
	String title;
	String parent;

	public Category( )
	{
		
	}

	public Category( String categoryId, String title, String parent)
	{
		this.categoryId = categoryId;
		this.title = title;
		this.parent = parent;
	}

	// initialiilze the DB table
	public static void initTable()
	{
		try{
			String query = "CREATE TABLE Category ( categoryId VARCHAR(30) ,  title VARCHAR(50) ,  parent VARCHAR(30) ) ;";
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
			if(DMManager.execQuery("SELECT * FROM Category WHERE categoryId = '" + categoryId + "'").next())
			{
				String query = "UPDATE Category SET categoryId = '"+categoryId+"' , title = '"+title+"' , parent = '"+parent+"' WHERE categoryId = '"+ categoryId + "'";
				DMManager.execDDLQuery( query );
			}else{
				String query = "INSERT INTO Category (categoryId, title, parent)  VALUES ('"+categoryId+"','"+title+"','"+parent+"')";
				DMManager.execDDLQuery( query );
			}
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}

	// public void delete()
	// {
	// 	try{
	// 		String query = "DELETE FROM User WHERE title = "+ title + " AND parent = " + parent;
	// 		DMManager.execDDLQuery( query );
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		 e.printStackTrace();
	// 	}
	// }

	public static ArrayList<Category> getAll()
	{
		return getAll("");
	}

	public static ArrayList<Category> getAll(String selector)
	{
		String query = "SELECT * FROM Category " + selector;
		ArrayList<Category>  r = new ArrayList<Category>();
		try{
			ResultSet resultSet = DMManager.execQuery(query);
	        while (resultSet.next()) {
		       Category t = new Category();
		       t.categoryId = resultSet.getString(1);
		       t.title = resultSet.getString(2);
		       t.parent = resultSet.getString(3);
		       r.add(t);
	    	}
		} catch(Exception e){
			 e.printStackTrace();
		}
    	return r;
	}
}
