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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TestForm{

    private void centerWindow(Shell shell) {

        Rectangle bds = shell.getDisplay().getBounds();

        Point p = shell.getSize();

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);
    }

    @SuppressWarnings("unused")
    public static void startForm() {

        Display d = new Display();
        Shell s = new Shell(d);

        s.setSize(500, 500);
        
        s.setText("App-Store");
        s.setLayout(new FillLayout());

        Table t = new Table(s, SWT.BORDER);

        TableColumn tc1 = new TableColumn(t, SWT.CENTER);
        TableColumn tc2 = new TableColumn(t, SWT.CENTER);
        TableColumn tc3 = new TableColumn(t, SWT.CENTER);
        tc1.setText("AppId");
        tc2.setText("Name");
        tc3.setText("Category");
        tc1.setWidth(70);
        tc2.setWidth(90);
        tc3.setWidth(80);
        t.setHeaderVisible(true);

        //One time:
        // try
        // {
        //     AndroidApp.initTable();   
        // }
        // catch(Exception e)
        // {
        //     System.out.println("AndroidApp table already exists");
        // }

        // To get some data:
        AndroidApp ap = new AndroidApp("Polo", "Ta", "Tyo","Olla","Dating","https://yts.ag",55);
        ap.save();

        ArrayList<AndroidApp> l = AndroidApp.getAll();
        
        
        for (AndroidApp te:l)
        {
            TableItem item = new TableItem(t, SWT.NONE);
            item.setText(new String[] { te.appId, te.name, te.category});    
        } 
        
        s.open();
        while (!s.isDisposed()) {
          if (!d.readAndDispatch())
            d.sleep();
        }

        d.dispose();

        }
}
