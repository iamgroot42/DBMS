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

public class AppInfoPage{

    private void centerWindow(Shell shell) {

        Rectangle bds = shell.getDisplay().getBounds();

        Point p = shell.getSize();

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);
    }

    @SuppressWarnings("unused")
    public static void startForm(AndroidApp ap) {

        Display d = new Display();
        Shell s = new Shell(d);

        s.setSize(400, 250);

        s.setText(ap.name);
        s.setLayout(new FillLayout());

        Table t = new Table(s, SWT.BORDER);

        TableColumn tc1 = new TableColumn(t, SWT.CENTER);
        TableColumn tc2 = new TableColumn(t, SWT.CENTER);
        tc1.setWidth(90);
        tc2.setWidth(90);
        t.setHeaderVisible(false);
                
        TableItem item;
        item = new TableItem(t, SWT.NONE);
        item.setText(new String[] {"Name", ap.name});     
        item = new TableItem(t, SWT.NONE);
        item.setText(new String[] {"AppId", ap.appId});     
        item = new TableItem(t, SWT.NONE);
        item.setText(new String[] {"Developer", ap.developer});     
        item = new TableItem(t, SWT.NONE);
        item.setText(new String[] {"Category", ap.category});     
        item = new TableItem(t, SWT.NONE);
        item.setText(new String[] {"Description", ap.description});     
        item = new TableItem(t, SWT.NONE);
        item.setText(new String[] {"Link", ap.link});     
        item = new TableItem(t, SWT.NONE);
        item.setText(new String[] {"Price", Integer.toString(ap.price)});     

        s.open();

        while (!s.isDisposed()) {
          if (!d.readAndDispatch())
            d.sleep();
        }
        d.dispose();
        }
}
