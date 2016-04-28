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
                ShowLoginPage();
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
                ShowLoginPage();
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











    @SuppressWarnings("unused")
    public static void startForm() {
    
        // Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(300, 200);
        shell.setText("Button Example");
        shell.setLayout(new RowLayout());





        final Button button = new Button(shell, SWT.PUSH);
        button.setText("Click Me");

        final Text text = new Text(shell, SWT.SHADOW_IN);

        button.addSelectionListener(new SelectionListener() {

             public void widgetSelected(SelectionEvent event) {
                text.setText("Potato!");
                ShowLoginPage();
              }

              public void widgetDefaultSelected(SelectionEvent event) {  }

        });


        attachShell( shell);

    }
}
