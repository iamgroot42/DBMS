package com.iiitd.dbms.app;

import java.util.*;

public class ManageApps {

    public static void addApp( String name , String appId ,String category, String description, String link , Integer price )
    {
        if(!(DeveloperLoginSystem.isLoggedIn))
        {
            return;
        }
        if(AndroidApp.getAll("WHERE appId = '" + appId +"'").size() != 0 )
        {
            System.out.println("App pehle se hai be");
            return;
        }

        AndroidApp ap = new AndroidApp(name,  DeveloperLoginSystem.loginUser   ,appId,category,description,link,price);
        ap.save();    
        
    }

    public static void removeApp(String appId)
    {
        if(!(DeveloperLoginSystem.isLoggedIn))
        {
            return;
        }
        
        if(AndroidApp.getAll("WHERE appId = '" + appId +"'").size() != 0 )
        {
            System.out.println("Pehle app bana to de be");
        }

        AndroidApp ap = AndroidApp.getByID(appId);
        ap.delete();
        
       
    }

    public static void updateApp( String name, String developer, String appId ,String category, String description, String link , Integer price )
    {
        if(!(DeveloperLoginSystem.isLoggedIn))
        {
            return;
        }
        if(AndroidApp.getByID(appId) == null)
        {
            System.out.println("Pehle aap to bana be");
        }
        if(DeveloperLoginSystem.loginUser.equals(developer))
        {
            AndroidApp ap = new AndroidApp(name,developer,appId,category,description,link,price);
            ap.save();    
        }
        else
        {
            System.out.println("Tu fraud hai be");
            return;
        }
    }

}
