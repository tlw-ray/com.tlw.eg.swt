package com.magus.eg.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class A03LayoutFill {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		
		FillLayout fillLayout=new FillLayout();
//		fillLayout.type=SWT.HORIZONTAL;
		fillLayout.marginHeight=10;
		fillLayout.marginWidth=10;
//		fillLayout.spacing=50;
		shell.setLayout(fillLayout);
		
		Button button01=new Button(shell, SWT.NONE);
		button01.setText("Button01");
		
//		Button button02=new Button(shell, SWT.NONE);
//		button02.setText("Button02");
		
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		
		display.dispose();
	}

}
