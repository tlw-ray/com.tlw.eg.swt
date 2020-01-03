package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class B01SelectListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Display display = new Display();
        final Shell shell = new Shell(display);
        
        shell.setLayout(new FillLayout());
        Button b=new Button(shell, SWT.NONE);
        b.setData(new Object());
        b.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				ColorDialog cd=new ColorDialog(shell, SWT.NONE);
				System.out.println("ok");
			}
        });
        
        shell.open();
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}

}
