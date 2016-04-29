package com.iiitd.dbms.app;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AndroidApp {

    String name;
    String developer;
    String appId;
    String category;
    String description;
    String link;
    Integer price;

    public AndroidApp( )
    {
        
    }

    public AndroidApp( String name, String developer, String appId ,String category, String description, String link , Integer price )
    {
        this.name = name;
        this.developer = developer;
        this.appId = appId;
        this.category = category;
        this.description = description;
        this.link = link;
        this.price = price;  
    }

    // initialiilze the DB table
    public static void initTable()
    {
        String query;
        try
        {
            query = "DROP TABLE AndroidApp;";
            DMManager.execDDLQuery( query );
        }
        catch(Exception e) {}
        try
        {
            query = "CREATE TABLE AndroidApp ( name VARCHAR(30), developer VARCHAR(30), appId VARCHAR(30), category VARCHAR(30), description VARCHAR(30), link VARCHAR(30), price int ) ;";
            DMManager.execDDLQuery( query );
        }   
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // take the id and add  it .... if exists then update it 
    public void save()
    {
        String query;
        try{
            if(DMManager.execQuery("SELECT * FROM AndroidApp WHERE appId = '"+ appId +"'").next())
            {
                query = "UPDATE AndroidApp SET  "
                +"name = '"+name
                +"' , developer = '"+developer
                +"' , appId = '"+appId
                +"' , category = '"+category
                +"' , description = '"+description
                +"' , link = '"+link
                +"' , price = '"+price

                +"' WHERE appId = '"+ appId + "'";    
                DMManager.execDDLQuery( query );
            }
           else{
             query = "INSERT INTO AndroidApp ( name, developer, appId, category, description, link,  price )  VALUES ('"+name + "','"+developer + "','"+appId + "','"+category + "','"+description + "','"+link + "','"+   price + "')";
            DMManager.execDDLQuery( query );
           }
        }
        catch(Exception e) {
              e.printStackTrace();
        }
       
    }

    public void delete()
    {
        try{
            String query = "DELETE FROM AndroidApp WHERE appId = '"+ appId + "'";
            DMManager.execDDLQuery(  query );
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }
    }

    public int getDownloads()
    {

        try{

            String query = "SELECT count(*) FROM Downloaded  WHERE appId = '"+ appId + "'";
            ResultSet resultSet = DMManager.execQuery(query);
            if(resultSet.next())
            {
                return Integer.parseInt(resultSet.getString(1));
            }


        }
        catch(Exception e)
        {
             e.printStackTrace();
        }

        return 0;

    }

    public static ArrayList<AndroidApp> getAll()
    {
        return getAll("");
    }

    public static AndroidApp getByID(String appId )
    {
        ArrayList<AndroidApp> aa =  getAll("WHERE appId = '" + appId +"'");
        
        // if( aa.size() == 0 )
        // {
        //     return NULL ;
        // }
        return aa.get(0);
    }

    public static ArrayList<AndroidApp> getAll(String selector)
    {

        String query = "SELECT * FROM AndroidApp " + selector;
        ArrayList<AndroidApp>  r = new ArrayList<AndroidApp>();

        try{
            ResultSet resultSet = DMManager.execQuery(query);
       
            while (resultSet.next()) {
               AndroidApp t = new AndroidApp();
               t.name = resultSet.getString(1);
               t.developer = resultSet.getString(2);
               t.appId = resultSet.getString(3);
               t.category = resultSet.getString(4);
               t.description = resultSet.getString(5);
               t.link = resultSet.getString(6);
               t.price = Integer.parseInt( resultSet.getString(7));

               r.add(t);
            }
        } catch(Exception e){
             e.printStackTrace();
        }
        return r;
    }



}
