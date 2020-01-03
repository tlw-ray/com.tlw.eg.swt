package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class A08Composite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        shell.setLayout(new FillLayout());
        
        Composite c=new Composite(shell, SWT.None);
        c.setLayout(new FillLayout());
        
        Button b=new Button(c,SWT.None);
        b.setText("xxx");
        
        shell.open();
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}

}
