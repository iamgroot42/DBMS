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

	 public static ArrayList<AndroidApp> getLiked(String userId)
	 {
	 	  return AndroidApp.getAll("where  appId in  (  select interest from  Interested where  userId =  '"+userId+"'  ) ");
	 }

	 public static ArrayList<AndroidApp> getTopApps()
	 {
	 	  return AndroidApp.getAll(""); // this is not ready either
	 }

	 public static ArrayList<AndroidApp> getPurchased(String userId)
	 {

	 	  return AndroidApp.getAll("where  appId in  (  select appId from  Downloaded where  userId =  '"+userId+"'  ) "); 
	 }

	 public static AndroidApp getById(String appId )
	 {
	 	return AndroidApp.getByID(appId);
	 }

	 public static void addAppToInterests( String appId )
	 {
	 		if(!(LoginSystem.isLoggedIn))
		 	{
		 		return;
		 	}

		 	Interested i = new Interested(  LoginSystem.loginUser , appId  );
		 	i.save();

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



	 	if( Downloaded.getAll( "WHERE userId = '"+ LoginSystem.loginUser + "' AND appId = '" + appId + "'").size() != 0 )
	 	{
	 		System.out.println("Already Downloadd");
	 		return;
	 	}

	 	Downloaded d = new Downloaded(  LoginSystem.loginUser , appId  );
	 	d.save();

	 	loggedInUser.credit -= appToPurchase.price;
	 	loggedInUser.save();



	 }



	 // #todo downloads and stats



}