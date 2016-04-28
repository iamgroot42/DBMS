package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



public class App 
{

    


    public static void main(String[] args) {

        TestForm.init();
        TestForm.startForm();
        
        

        /*
        Downloaded.initTable();
        User.initTable();
        Ratings.initTable();
        Category.initTable();
        Interested.initTable();

        Downloaded d = new Downloaded("crossy","hvk");
        d.save();

        Category i = new Category("11ef2es" , "dating" , "social");
        i.save();

    	User u = new User("divam" , "dbhebfbeh" , "1231");
    	u.save();

        Ratings r = new Ratings(4 , "tamatar" , "patata");
        r.save();

        Interested in = new Interested("hvk","ohho");
        in.save();
        
        // to get All the stuff
        ArrayList<Interested> dd = Interested.getAll();
        for (Interested pp:dd)
        {
            System.out.println(pp.userId);
            System.out.println(pp.interest);
        }
        
        // to get All the stuff
        ArrayList<Downloaded> dd = Downloaded.getAll();
        for (Downloaded pp:dd)
        {
            System.out.println(pp.appId);
            System.out.println(pp.userId);
        }

        // to get All the stuff
        ArrayList<Category> tt = Category.getAll();
        for (Category zz:tt)
        {
            System.out.println(zz.categoryId);
            System.out.println(zz.title);
            System.out.println(zz.parent);
        }

        // to get All the stuff
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
        */

    	// DMManager.testDB();
        // get("/hello", (req, res) -> "Hello World");



    }
}
