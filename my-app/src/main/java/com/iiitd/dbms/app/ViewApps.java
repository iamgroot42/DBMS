package com.iiitd.dbms.app;

import java.util.*;

public class ViewApps {

	 public static ArrayList<AndroidApp> getByCategory(String category)
	 {
	 	  return AndroidApp.getAll("WHERE category = '" + category +"'");
	 }

	 public static ArrayList<AndroidApp> searchApps(String query)
	 {
	 	  return AndroidApp.getAll("WHERE name LIKE '%" + query +"%'  OR  developer LIKE '%"+query+"%'");
	 }

	 public static ArrayList<AndroidApp> getByDeveloper(String developer)
	 {
	 	  return AndroidApp.getAll("WHERE developer = '" + developer +"'");
	 }

	 public static ArrayList<AndroidApp> getLiked(String user)
	 {
	 	  return AndroidApp.getAll("WHERE developer = '" + user +"'"); // thsi is not ready
	 }

	 public static ArrayList<AndroidApp> getTopApps()
	 {
	 	  return AndroidApp.getAll(""); // thsi is not ready either
	 }

	 public static ArrayList<AndroidApp> getPurchased(String user)
	 {
	 	  return AndroidApp.getAll(""); // thsi is not ready either
	 }

	 public static AndroidApp getById(String appId )
	 {
	 	return AndroidApp.getByID(appId);
	 }

	 public static void purchaseApp( String appId )
	 {
	 	if(!(LoginSystem.isLoggedIn))
	 	{
	 		return;
	 	}

	 	AndroidApp appToPurchase =  AndroidApp.getByID(appId);
	 	User loggedInUser = User.getByID(LoginSystem.loginUser );

	 	if(  appToPurchase.price  > loggedInUser.credit  )
	 	{
	 		System.out.println("Balance kam hai be");
	 		return;
	 	}

	 	// #todo check if purchased

	 	// #todo add to purchased

	 	loggedInUser.credit -= appToPurchase.price;
	 	loggedInUser.save();



	 }



	 // #todo downloads and stats



}