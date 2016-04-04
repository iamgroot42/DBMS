package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeveloperLoginSystem {


	public static Boolean isLoggedIn = false;
	public static String loginUser;

	public static Boolean checkLogin( String user , String pass )
	{
		if( Developer.getAll( "WHERE passwordHash =  "+pass+"  AND userId  = " + user).size()> 0  )
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
		if( Developer.getAll( "WHERE userId = " + userId).size() != 0  )
		{
			System.out.println("you registered nigga");
			return;
		}

		Developer uu = new Developer(name , passwordHash , userId , 0 );
		uu.save();

	}

}