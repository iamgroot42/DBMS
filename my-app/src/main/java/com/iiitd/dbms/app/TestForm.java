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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

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
    
        Display display = new Display();
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
          }

          public void widgetDefaultSelected(SelectionEvent event) {
            text.setText("Tomato!");
          }
        });
        shell.open();
        while (!shell.isDisposed()) {
          if (!display.readAndDispatch())
            display.sleep();
        }
        display.dispose();
    }
}
