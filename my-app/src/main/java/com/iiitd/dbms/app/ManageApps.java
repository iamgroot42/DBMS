package com.iiitd.dbms.app;

import java.util.*;

public class ManageApps {

    public static void addApp( String name, String developer, String appId ,String category, String description, String link , Integer price )
    {
        if(!(DeveloperLoginSystem.isLoggedIn))
        {
            return;
        }
        if(AndroidApp.getByID(appId) != null)
        {
            System.out.println("App pehle se hai be");
            return;
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

    public static void removeApp(String appId)
    {
        if(!(DeveloperLoginSystem.isLoggedIn))
        {
            return;
        }
        AndroidApp ap = AndroidApp.getByID(appId);
        if (ap == null)
        {
            System.out.println("Pehle app bana to de be");
        }
        if ( ap.developer.equals(DeveloperLoginSystem.loginUser) )
        {
            ap.delete();
        }
        else
        {
            System.out.println("Teri app nahi hai be");
            return;
        }
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