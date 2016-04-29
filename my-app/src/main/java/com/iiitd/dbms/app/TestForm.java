package com.iiitd.dbms.app;

import java.util.*;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.*;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;


public class TestForm{


    // THE CODE FOR THE UI BACKBONE
    static Display display;


    public static void init()
    {
        display =  new Display();
    }

    static void attachShell(Shell shell)
    {
        shell.open();
        while (!shell.isDisposed()) {
          if (!display.readAndDispatch())
            display.sleep();
        }
       // display.dispose();
    }






    // ACTUAL FORMS

    public static void showUserDashBoard()
    {
        Shell shell = new Shell(display);
        shell.setSize(300, 700);


        User curU =   User.getByID ( LoginSystem.loginUser ); 

        shell.setText("Welcome User " + curU.name);
        shell.setLayout(new GridLayout( 1 , true ));


        Label label1=new Label(shell, SWT.NULL);
        label1.setText("Welcome " + curU.name);


        label1=new Label(shell, SWT.NULL);
        label1.setText("Credit  " + curU.credit );

        final Button settingsButt = new Button(shell, SWT.PUSH);
        settingsButt.setText("Settings");

        final Button searchApps = new Button(shell, SWT.PUSH);
        searchApps.setText("Search Apps");

        final Button viewCategories = new Button(shell, SWT.PUSH);
        viewCategories.setText("View Categories");

        final Button allApps = new Button(shell, SWT.PUSH);
        allApps.setText("allApps");

        final Button topApps = new Button(shell, SWT.PUSH);
        topApps.setText("topApps");

        // final Button allDevelopers = new Button(shell, SWT.PUSH);
        // allDevelopers.setText("allDevelopers");

        final Button myPurchased = new Button(shell, SWT.PUSH);
        myPurchased.setText("myPurchased");

        final Button myIntrestedApps = new Button(shell, SWT.PUSH);
        myIntrestedApps.setText("myIntrestedApps");

        final Button allRatingsButton = new Button(shell, SWT.PUSH);
        allRatingsButton.setText("allRatingsButton");


        allApps.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                 // AndroidApp a = new AndroidApp( "crozzy sity", "divam", "com.ff.ff" ,"s", "String descriptionString descriptionString description", "htto" , 23   );
                 // showApp(a);
                showTable ( AndroidApp.getAll() , "All Apps ");
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

         settingsButt.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showUserSettings();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

        topApps.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showTable(ViewApps.getTopApps() , "Top Apps");
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

        myPurchased.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showTable(ViewApps.getPurchased(LoginSystem.loginUser) , "My Purchased Apps");
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

         myIntrestedApps.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showTable(ViewApps.getLiked(LoginSystem.loginUser) , "My Whislist");
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

         allRatingsButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                 showRatings(ViewRatings.getRatingsOfUser( LoginSystem.loginUser  ) , "My All Ratings");
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

         searchApps.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    String query = prompt("Enter the Search query ");
                    showTable(ViewApps.searchApps(query) , "Search Results of "+query);
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });




        attachShell( shell);

    }



    public  static void developerDashBoard()
    {
         Shell shell = new Shell(display);
        shell.setSize(300, 700);


        Developer curU =   Developer.getByID ( DeveloperLoginSystem.loginUser ); 

        shell.setText("Welcome User " + curU.name);
        shell.setLayout(new GridLayout( 1 , true ));

        final Button addAppButt = new Button(shell, SWT.PUSH);
        addAppButt.setText("Add App");

        final Button viewAppsButton = new Button(shell, SWT.PUSH);
        viewAppsButton.setText("viewAppsButton");

        final Button addCategoryButton = new Button(shell, SWT.PUSH);
        addCategoryButton.setText("addCategoryButton");

        addAppButt.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                 showNewAppScreen();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

        addCategoryButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                 showNewCategoryScreen();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

        viewAppsButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showTable(ViewApps.getByDeveloper( DeveloperLoginSystem.loginUser  ) , "My Apps ");
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });


        attachShell( shell);

    }





    public static void alert(String msg )
    {
        Shell shell = new Shell(display);
        shell.setSize(300, 100);
        shell.setText("Alert");
        shell.setLayout(new RowLayout());


         Label label1=new Label(shell, SWT.NULL);
        label1.setText(msg);

        final Button button = new Button(shell, SWT.PUSH);
        button.setText("Okay");

       

        button.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
               shell.dispose();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });


        attachShell( shell);
    }

    public static String prompt(String msg )
    {
        Shell shell = new Shell(display);
        shell.setSize(300, 100);
        shell.setText("Alert");
        shell.setLayout(new RowLayout());


         Label label1=new Label(shell, SWT.NULL);
        label1.setText(msg);

        final Text input = new Text(shell, SWT.SHADOW_IN);



        final Button button = new Button(shell, SWT.PUSH);
        button.setText("Okay");

        final String[] result = new String[1];


       

        button.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    result[0] = input.getText();
                    shell.dispose();
                    
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

       
        attachShell( shell);

        return result[0] ;

    }


    public static void showApp(AndroidApp  a )
    {

        Shell shell = new Shell(display);
        shell.setSize(700, 700);
        shell.setText(a.name);
        shell.setLayout(new GridLayout( 2 , true ));

        Label l = new Label(shell, SWT.NULL);
        l.setText("Name :  ");
        l = new Label(shell, SWT.NULL);
        l.setText(a.name );

        l = new Label(shell, SWT.NULL);
        l.setText("Price");
        l = new Label(shell, SWT.NULL);
        l.setText( ""+a.price);

        l = new Label(shell, SWT.NULL);
        l.setText("Buy");
        final Button buyButton = new Button(shell, SWT.PUSH);
        buyButton.setText("buyButton");

         l = new Label(shell, SWT.NULL);
        l.setText("Interested");
        final Button addToInterestsButton = new Button(shell, SWT.PUSH);
        addToInterestsButton.setText("addToInterests");

        l = new Label(shell, SWT.NULL);
        l.setText("Developer");
         final Button developerButton = new Button(shell, SWT.PUSH);
        developerButton.setText(a.developer);


        l = new Label(shell, SWT.NULL);
        l.setText("Category");
         final Button categoryButton = new Button(shell, SWT.PUSH);
        categoryButton.setText(a.category);

         l = new Label(shell, SWT.NULL);
        l.setText("Pakage Name");
        l = new Label(shell, SWT.NULL);
        l.setText(a.appId);


        l = new Label(shell, SWT.NULL);
        l.setText("Description");
         l = new Label(shell, SWT.NULL);
        l.setText(a.description);

        l = new Label(shell, SWT.NULL);
        l.setText("External Link");
        l = new Label(shell, SWT.NULL);
        l.setText(a.link);


        l = new Label(shell, SWT.NULL);
        l.setText("Rate ! ");
        final Button rateButton = new Button(shell, SWT.PUSH);
        rateButton.setText(a.developer);

        l = new Label(shell, SWT.NULL);
        l.setText("View Ratings  ");
        final Button viewRatingsButton = new Button(shell, SWT.PUSH);
        viewRatingsButton.setText(a.developer);

         l = new Label(shell, SWT.NULL);
        l.setText("Total Downloads : ");
        l = new Label(shell, SWT.NULL);
        l.setText("" + a.getDownloads() );



        buyButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    ViewApps.purchaseApp(a.appId);
             }

             public void widgetDefaultSelected(SelectionEvent event) {  }

        });

        addToInterestsButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    ViewApps.addAppToInterests(a.appId);
             }

             public void widgetDefaultSelected(SelectionEvent event) {  }

        });


        developerButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showTable(ViewApps.getByDeveloper( a.developer ) , "Apps By " + a.developer);
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

        categoryButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showTable(ViewApps.getByCategory( a.category ) , "Apps Of category  " + a.category);
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

        rateButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                  Integer r = Integer.parseInt( prompt("Please Enter the rating")  );
                  ViewRatings.addRating( r , a.appId , LoginSystem.loginUser   );
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });



         viewRatingsButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                 showRatings(ViewRatings.getRatingsOfApp( a.appId  ) , "All Ratings of " + a.name );
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });




        attachShell( shell);
    }


    public static void showNewCategoryScreen()
    {
        Shell shell = new Shell(display);
        shell.setSize(700, 700);
        shell.setText("New Category");
        shell.setLayout(new GridLayout( 2 , true ));

        Label l = new Label(shell, SWT.NULL);
        l.setText("Category Name : ");
        final Text name = new Text(shell, SWT.SHADOW_IN);

        l = new Label(shell, SWT.NULL);
        l.setText("Category ID : ");
        final Text catId = new Text(shell, SWT.SHADOW_IN);

        l = new Label(shell, SWT.NULL);
        l.setText("Parent Category ID : ");
        final Text parentId = new Text(shell, SWT.SHADOW_IN);

        final Button doneButton = new Button(shell, SWT.PUSH);
        doneButton.setText("Done !!! ");

        doneButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                  Category c = new Category( catId.getText() ,   name.getText()  , parentId.getText());
                  c.save();
                  alert("Category Added! ");
                  shell.dispose();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });


        attachShell( shell);
    }


    public static void showNewAppScreen()
    {
        Shell shell = new Shell(display);
        shell.setSize(700, 700);
        shell.setText("new App ");
        shell.setLayout(new GridLayout( 2 , true ));

        Label l = new Label(shell, SWT.NULL);
        l.setText("Name :  ");
        final Text name = new Text(shell, SWT.SHADOW_IN);

        l = new Label(shell, SWT.NULL);
        l.setText("Price");
        final Text price = new Text(shell, SWT.SHADOW_IN);

        l = new Label(shell, SWT.NULL);
        l.setText("Category");
        final Text cat = new Text(shell, SWT.SHADOW_IN);

         l = new Label(shell, SWT.NULL);
        l.setText("Pakage Name");
        final Text packagename = new Text(shell, SWT.SHADOW_IN);

        l = new Label(shell, SWT.NULL);
        l.setText("Description");
        final Text discription = new Text(shell, SWT.SHADOW_IN);
    

        l = new Label(shell, SWT.NULL);
        l.setText("External Link");
        final Text link = new Text(shell, SWT.SHADOW_IN);


        final Button button = new Button(shell, SWT.PUSH);
        button.setText("Add");

       

        button.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    ManageApps.addApp( name.getText() ,packagename.getText() ,cat.getText() ,discription.getText(), link.getText() , Integer.parseInt(price.getText()) );
             }

             public void widgetDefaultSelected(SelectionEvent event) {  }

        });


        attachShell( shell);
    }


    public static void showUserSettings()
    {
        Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("User Settings");
        shell.setLayout(new GridLayout(2 , true ));


        final Text bal = new Text(shell, SWT.SHADOW_IN);

        final Button ddCredButton = new Button(shell, SWT.PUSH);
        ddCredButton.setText("Add Balance");


        ddCredButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    LoginSystem.addCredit(  Integer.parseInt(bal.getText())  );
                    alert("Credit Added");
                    shell.dispose();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

         });


        attachShell(shell);

    }


    public static void showRegisterPage()
    {
         Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("Register");
        shell.setLayout(new GridLayout(2 , true ));

        Label label1=new Label(shell, SWT.NULL);
        label1.setText("Name: ");

        final Text textBoxName = new Text(shell, SWT.SHADOW_IN);

        label1=new Label(shell, SWT.NULL);
        label1.setText("Username: ");


        final Text textBoxUsername = new Text(shell, SWT.SHADOW_IN);

        label1=new Label(shell, SWT.NULL);
        label1.setText("Password: ");


        final Text textBoxPassword = new Text(shell, SWT.SHADOW_IN);

        final Button registerButton = new Button(shell, SWT.PUSH);
        registerButton.setText("Register");


        registerButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    

                    Boolean x = LoginSystem.register( textBoxName.getText() , textBoxPassword.getText() , textBoxUsername.getText() );
                    if(x)
                    {
                        alert("Registration succesful");
                        shell.dispose();
                    }
                    else
                    {
                        alert("Sorry cant Register ... try another username");
                    }

              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

         });


        attachShell( shell);

    }



     public static void showDevRegisterPage()
    {
         Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("Register");
        shell.setLayout(new GridLayout(2 , true ));

        Label label1=new Label(shell, SWT.NULL);
        label1.setText("Name: ");

        final Text textBoxName = new Text(shell, SWT.SHADOW_IN);

        label1=new Label(shell, SWT.NULL);
        label1.setText("Username: ");


        final Text textBoxUsername = new Text(shell, SWT.SHADOW_IN);

        label1=new Label(shell, SWT.NULL);
        label1.setText("Password: ");


        final Text textBoxPassword = new Text(shell, SWT.SHADOW_IN);

        final Button registerButton = new Button(shell, SWT.PUSH);
        registerButton.setText("Register");


        registerButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                    

                    Boolean x = DeveloperLoginSystem.register( textBoxName.getText() , textBoxPassword.getText() , textBoxUsername.getText() );
                    if(x)
                    {
                        alert("Registration succesful");
                        shell.dispose();
                    }
                    else
                    {
                        alert("Sorry cant Register ... try another username");
                    }

              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

         });


        attachShell( shell);

    }



    public static void ShowLoginPage()
    {
        // Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("Login");
        shell.setLayout(new GridLayout(2 , true ));



        
        Label label1=new Label(shell, SWT.NULL);
        label1.setText("Username: ");
        final Text textBoxUsername = new Text(shell, SWT.SHADOW_IN);
        label1=new Label(shell, SWT.NULL);
        label1.setText("Passowrd: ");
        final Text textBoxPassword = new Text(shell, SWT.SHADOW_IN);

        final Button registerButton = new Button(shell, SWT.PUSH);
        registerButton.setText("Register");

        final Button loginButton = new Button(shell, SWT.PUSH);
        loginButton.setText("Login");



         loginButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {


                if(LoginSystem.checkLogin( textBoxUsername.getText()  ,  textBoxPassword.getText()  ))
                {
                     alert("Login succesful!");
                     shell.dispose();
                      showUserDashBoard();
                }
                else
                {
                     alert("Login Failed!");
                }

               

              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

         });


        



         registerButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showRegisterPage();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

         });


         attachShell( shell);


    }


     public static void ShowDevLoginPage()
    {
        // Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("Login");
        shell.setLayout(new GridLayout(2 , true ));



        
        Label label1=new Label(shell, SWT.NULL);
        label1.setText("Username: ");
        final Text textBoxUsername = new Text(shell, SWT.SHADOW_IN);
        label1=new Label(shell, SWT.NULL);
        label1.setText("Passowrd: ");
        final Text textBoxPassword = new Text(shell, SWT.SHADOW_IN);

        final Button registerButton = new Button(shell, SWT.PUSH);
        registerButton.setText("Register");

        final Button loginButton = new Button(shell, SWT.PUSH);
        loginButton.setText("Login");



         loginButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {


                if(DeveloperLoginSystem.checkLogin( textBoxUsername.getText()  ,  textBoxPassword.getText()  ))
                {
                     alert("Login succesful!");
                     shell.dispose();
                     developerDashBoard();
                }
                else
                {
                     alert("Login Failed!");
                }

               

              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

         });


        



         registerButton.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                showDevRegisterPage();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

         });


         attachShell( shell);


    }






    @SuppressWarnings("unused")
    public static void startForm() {
    
        // Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("Button Example");
        shell.setLayout(new RowLayout());





        final Button button = new Button(shell, SWT.PUSH);
        button.setText("User");

        final Button devBtn = new Button(shell, SWT.PUSH);
        devBtn.setText("Developers");


        button.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                ShowLoginPage();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });

         devBtn.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                ShowDevLoginPage();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });


        attachShell( shell);

    }







     public static void showTable(ArrayList<AndroidApp> apps, String heading) {

        // Display d = new Display();
        Shell s = new Shell(display);

        s.setSize(800, 800);        
        s.setText(heading);
        s.setLayout(new FillLayout());

        Table t = new Table(s, SWT.BORDER);

        TableColumn tc1 = new TableColumn(t, SWT.CENTER);
        TableColumn tc2 = new TableColumn(t, SWT.CENTER);
        TableColumn tc3 = new TableColumn(t, SWT.CENTER);
        TableColumn tc4 = new TableColumn(t, SWT.CENTER);
        TableColumn tc5 = new TableColumn(t, SWT.CENTER);
        TableColumn tc6 = new TableColumn(t, SWT.CENTER);
        TableColumn tc7 = new TableColumn(t, SWT.CENTER);
        TableColumn tc8 = new TableColumn(t, SWT.CENTER);
        tc1.setText("Name");
        tc2.setText("Developer");
        tc3.setText("AppId");
        tc4.setText("Category");
        tc5.setText("Description");
        tc6.setText("Link");
        tc7.setText("Price");
        tc8.setText("View App");
        tc1.setWidth(100);
        tc2.setWidth(100);
        tc3.setWidth(50);
        tc4.setWidth(100);
        tc5.setWidth(110);
        tc6.setWidth(110);
        tc7.setWidth(70);
        tc8.setWidth(40);
        t.setHeaderVisible(true);


        Button[] buts = new Button[apps.size()+1];
        TableEditor[] colorEditors = new TableEditor[apps.size()+1];

         int i ;
        i = 0;
        for (AndroidApp te:apps)
        {
            colorEditors[i] = new TableEditor(t);
            TableItem item = new TableItem(t, SWT.NONE);
            item.setText(new String[] { te.name, te.developer, te.appId, te.category, te.description, te.link, Integer.toString(te.price)});    


            buts[i] = new Button(t, SWT.PUSH);

            buts[i].setText("View");
            colorEditors[i].grabHorizontal = true;
            colorEditors[i].minimumHeight = buts[i].getSize().y-5;
            colorEditors[i].minimumWidth = buts[i].getSize().x;

            colorEditors[i].setEditor(buts[i], item, 7);

          
            buts[i].addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                System.out.println("Press detected");
                     showApp(te );

                }
            }); 
            i++;
        } 

       attachShell(s);
    }



     public static void showRatings( ArrayList<Ratings>  ratings, String heading) {

        // Display d = new Display();
        Shell s = new Shell(display);

        s.setSize(800, 800);        
        s.setText(heading);
        s.setLayout(new FillLayout());

        Table t = new Table(s, SWT.BORDER);

        TableColumn tc1 = new TableColumn(t, SWT.CENTER);
        TableColumn tc2 = new TableColumn(t, SWT.CENTER);
        TableColumn tc3 = new TableColumn(t, SWT.CENTER);
        TableColumn tc4 = new TableColumn(t, SWT.CENTER);
       
        tc1.setText("AppId");
        tc2.setText("UserID");
        tc3.setText("Stars");
        tc4.setText("View App ");


        tc1.setWidth(100);
        tc2.setWidth(100);
        tc3.setWidth(50);
        tc4.setWidth(100);

        t.setHeaderVisible(true);

        Button[] buts = new Button[ratings.size()+1];
        TableEditor[] colorEditors = new TableEditor[ratings.size()+1];

         int i ;
        i = 0;
        for (Ratings te:ratings)
        {
            colorEditors[i] = new TableEditor(t);
            TableItem item = new TableItem(t, SWT.NONE);
            item.setText(new String[] { te.appId, te.userId, Integer.toString(te.rating) });    


            buts[i] = new Button(t, SWT.PUSH);

            buts[i].setText("View");
            colorEditors[i].grabHorizontal = true;
            colorEditors[i].minimumHeight = buts[i].getSize().y-5;
            colorEditors[i].minimumWidth = buts[i].getSize().x;

            colorEditors[i].setEditor(buts[i], item, 3);

          
            buts[i].addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                System.out.println("Press detected");
                    showApp(  AndroidApp.getByID( te.appId ) );
                
                }
            }); 
            i++;
        } 

       attachShell(s);
    }







}
