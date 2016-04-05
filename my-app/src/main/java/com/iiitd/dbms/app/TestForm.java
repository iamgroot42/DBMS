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

        s.setSize(800, 500);
        
        s.setText("App-Store");
        s.setLayout(new FillLayout());

        Table t = new Table(s, SWT.BORDER);

        TableColumn tc1 = new TableColumn(t, SWT.CENTER);
        TableColumn tc2 = new TableColumn(t, SWT.CENTER);
        TableColumn tc3 = new TableColumn(t, SWT.CENTER);
        TableColumn tc4 = new TableColumn(t, SWT.CENTER);
        TableColumn tc5 = new TableColumn(t, SWT.CENTER);
        TableColumn tc6 = new TableColumn(t, SWT.CENTER);
        TableColumn tc7 = new TableColumn(t, SWT.CENTER);
        tc1.setText("Name");
        tc2.setText("Developer");
        tc3.setText("AppId");
        tc4.setText("Category");
        tc5.setText("Description");
        tc6.setText("Link");
        tc7.setText("Price");
        tc1.setWidth(70);
        tc2.setWidth(90);
        tc3.setWidth(80);
        tc4.setWidth(80);
        tc5.setWidth(150);
        tc6.setWidth(100);
        tc7.setWidth(80);
        t.setHeaderVisible(true);

        AndroidApp ap = new AndroidApp("Po", "Ta", "To","Olla","Dating","https://yts.ag",55);
        ArrayList<AndroidApp> l = new ArrayList<AndroidApp>();

        for(int i=0;i<50;i++)
        {
            l.add(ap);    
        }

        for(int i=0;i<50;i++)
        {
            AndroidApp te = l.get(i);
            TableItem item = new TableItem(t, SWT.NONE);
            item.setText(new String[] { te.name, te.developer, te.appId,te.category,te.description,te.link,Integer.toString(te.price)});    
        } 
        

        s.open();
        while (!s.isDisposed()) {
          if (!d.readAndDispatch())
            d.sleep();
        }

        d.dispose();

        }
}
