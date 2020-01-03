package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class A07Group {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		
		FillLayout fillLayout=new FillLayout();
		shell.setLayout(fillLayout);
		
		Group group0=new Group(shell, SWT.NONE);
		group0.setText("Group0");
		
		Group group1=new Group(shell, SWT.BORDER_DOT);
		group1.setText("Group1");
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
	}

}
