package com.magus.eg.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class A04LayoutRow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		
		RowLayout rowLayout=new RowLayout();
		rowLayout.fill=false;
		rowLayout.center=true;
		rowLayout.justify=true;
		rowLayout.type=SWT.VERTICAL;
		rowLayout.marginWidth=200;
		rowLayout.marginRight=50;
		shell.setLayout(rowLayout);
		
		Button button01=new Button(shell, SWT.None);
		button01.setText("b1");
		
		
		Button button02=new Button(shell, SWT.None);
		button02.setText("b2");
		
		Button button03=new Button(shell, SWT.None);
		button03.setText("b3");
		
		Button button04=new Button(shell, SWT.None);
		button04.setText("b4");
		
		RowData rd01=new RowData();
		rd01.width=100;
		rd01.height=100;
		button01.setLayoutData(rd01);
		
		RowData rd02=new RowData();
		rd02.width=70;
		rd02.height=70;
		button02.setLayoutData(rd02);
		
		RowData rd03=new RowData();
		rd03.exclude=true;
		button03.setLayoutData(rd03);
		
		RowData rd04=new RowData();
		rd04.width=40;
		rd04.height=40;
		button04.setLayoutData(rd04);
		
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}

}
