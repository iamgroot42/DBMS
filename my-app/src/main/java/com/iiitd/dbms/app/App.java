package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main(String[] args) {
        
    	User.initTable();
        Ratings.initTable();

    	User u = new User("divam" , "dbhebfbeh" , "1231");
    	u.save();

        Ratings r = new Ratings(4,"tamatar","patata");
        r.save();

        ArrayList<Ratings> rr = Ratings.getAll();
        for (Ratings ss:rr)
        {
            System.out.println(ss.rating);
            System.out.println(ss.appId);
            System.out.println(ss.userId);
        }

    	// to get All the stuff
    	ArrayList<User> dd = User.getAll();

    	for( User uu : dd)
    	{
    		System.out.println(uu.name);
    		System.out.println(uu.userId);
    	}
    	// DMManager.testDB();
        // get("/hello", (req, res) -> "Hello World");
    }
}
