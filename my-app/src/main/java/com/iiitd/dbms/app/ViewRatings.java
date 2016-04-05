package com.iiitd.dbms.app;

import java.util.*;

public class ViewRatings {


	public static ArrayList<Ratings> getRatingsOfApp(String appId)
	{
		return Ratings.getAll("WHERE appId = '" +  appId +"'");
	}

	public static ArrayList<Ratings> getRatingsOfUser(String userId)
	{
		return Ratings.getAll("WHERE userId = '" +  userId +"'");
	}

	public static void addRating(int rating, String appId, String userId)
	{
		Ratings r = new Ratings( rating,  appId,  userId);
		r.save();
	}

	public static void deleteRating(int rating, String appId, String userId)
	{
		Ratings r =  Ratings.getByID( userId , appId );
		r.save();
	}


}