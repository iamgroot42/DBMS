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

     public App(Display display) {
       
        Shell shell = new Shell(display);
        shell.setText("Center");
        shell.setSize(250, 200);

        centerWindow(shell);

        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }


    private void centerWindow(Shell shell) {

        Rectangle bds = shell.getDisplay().getBounds();

        Point p = shell.getSize();

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);
    }


    public static void main(String[] args) {


        Display display = new Display();
        App ex = new App(display);
        display.dispose();

        


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
