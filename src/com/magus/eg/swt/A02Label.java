package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class A02Label {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		Label label=new Label(shell, SWT.NONE);
		
		label.setText("Hello!\nHello!");
		
		label.setBounds(shell.getClientArea());
		
		Color color=display.getSystemColor(SWT.COLOR_WHITE);
		label.setBackground(color);

		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}
}