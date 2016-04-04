package com.iiitd.dbms.app;

import java.util.*;

public class ViewRatings {


	public static ArrayList<Ratings> getRatingsOfApp(String appId)
	{
		return Ratings.getAll("WHERE appId = '" +  appId +"'")
	}

	public static ArrayList<Ratings> getRatingsOfUser(String userId)
	{
		return Ratings.getAll("WHERE userId = '" +  userId +"'")
	}


	// get ratings of an app 

	// add rating
		// check if rating exist
	// delete rating

	// see all my ratings
}