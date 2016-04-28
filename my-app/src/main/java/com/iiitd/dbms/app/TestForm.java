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

        final Button allDevelopers = new Button(shell, SWT.PUSH);
        allDevelopers.setText("allDevelopers");

        final Button myPurchased = new Button(shell, SWT.PUSH);
        myPurchased.setText("myPurchased");


        allApps.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                 AndroidApp a = new AndroidApp( "crozzy sity", "divam", "com.ff.ff" ,"s", "String descriptionString descriptionString description", "htto" , 23   );
                 showApp(a);
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

        addAppButt.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                 showNewAppScreen();
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
        l.setText("Description");
         l = new Label(shell, SWT.NULL);
        l.setText(a.description);

        l = new Label(shell, SWT.NULL);
        l.setText("External Link");
        l = new Label(shell, SWT.NULL);
        l.setText(a.link);



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
        shell.setText("Register");
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

        // Shell child2 = new Shell(s, SWT.TITLE|SWT.SYSTEM_MODAL| SWT.CLOSE | SWT.MAX);
        // child2.setSize(300, 300);
        // child2.setLayout(new GridLayout());
        // child2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        // child2.open();

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
                // Display app's info
                // Maybe useful:
                // Shell child2 = new Shell(s, SWT.TITLE|SWT.SYSTEM_MODAL| SWT.CLOSE | SWT.MAX);
                // child2.setSize(300, 300);
                // child2.setLayout(new GridLayout());
                // child2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
                // child2.open();
            }
            }); 
            i++;
        } 

       attachShell(s);
    }







}
