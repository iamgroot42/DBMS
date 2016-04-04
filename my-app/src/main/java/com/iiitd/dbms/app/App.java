package com.iiitd.dbms.app;

import static spark.Spark.*;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */


public class App 
{
	// start spark server
    public static void main(String[] args) {

    	// uncomment this for the first time
    	// User.initTable();

    	User uu = new User("shivam" , "dbhebfbeh" , "1231" , 676);
    	uu.save();
    	// uu.delete();


    	// to get All the stuff

    	ArrayList<User> dd = User.getAll();

    	for( User u : dd)
    	{
    		System.out.println(u.name);
    		System.out.println(u.userId);
            System.out.println(u.credit);
    	}



    	// DMManager.testDB();


        get("/hello", (req, res) -> "Hello World");
    }
}




