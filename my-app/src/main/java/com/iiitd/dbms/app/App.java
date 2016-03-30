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

    	// User u = new User("divam" , "dbhebfbeh" , "1231");
    	// u.save();


    	// to get All the stuff

    	// ArrayList<User> dd = User.getAll();

    	// for( User u : dd)
    	// {
    	// 	System.out.println(u.name);
    	// 	System.out.println(u.userId);
    	// }



    	// DMManager.testDB();


        get("/hello", (req, res) -> "Hello World");
    }
}




