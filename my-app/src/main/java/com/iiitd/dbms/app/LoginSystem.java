package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginSystem {

	public static Boolean isLoggedIn = false;
	public static String loginUser;

	public static Boolean checkLogin( String user , String pass )
	{
		if( User.getAll( "WHERE passwordHash =  "+pass+"  AND userId  = " + user).size()> 0  )
		{
			loginUser = user;
			isLoggedIn = true;
			return true;
		}
		else return false;
	}

	public static void logout()
	{
		isLoggedIn = false;
	}

	public static void register( String name, String passwordHash, String userId  )
	{
		if( User.getAll( "WHERE userId = " + userId).size() != 0  )
		{
			System.out.println("you registered nigga");
			return;
		}

		User uu = new User(name , passwordHash , userId , 0 );
		uu.save();
	}

	public static void addCredit( int money )
	{
		User loggedInUser = User.getByID(loginUser );
		loggedInUser.credit += money;
		loggedInUser.save();
	}

}