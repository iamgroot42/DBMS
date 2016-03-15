package com.iiitd.dbms.app;

import static spark.Spark.*;


/**
 * Hello world!
 *
 */
public class App 
{
	// start spark server
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}




