package com.magus.eg.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class A05LayoutGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        GridLayout gridLayout=new GridLayout();
        gridLayout.numColumns=2;
        
        gridLayout.marginHeight=0;
        gridLayout.marginWidth=0;
        
        gridLayout.horizontalSpacing=0;
        gridLayout.verticalSpacing=0;
        
        gridLayout.marginTop=0;
        gridLayout.marginBottom=0;
        gridLayout.marginLeft=0;
        gridLayout.marginRight=0;
        
        gridLayout.makeColumnsEqualWidth=false;
        shell.setLayout(gridLayout);
        
        Color bg=display.getSystemColor(SWT.COLOR_WHITE);
        Color bg1=display.getSystemColor(SWT.COLOR_RED);
        shell.setBackground(bg);
        
        Button b0=new Button(shell, SWT.None);
        b0.setText("b0");
        b0.setBackground(bg1);
        Button b1=new Button(shell, SWT.None);
        b1.setText("b1");
        Button b2=new Button(shell, SWT.None);
        b2.setText("b2");
        Button b3=new Button(shell, SWT.None);
        b3.setText("b3");
        Button b4=new Button(shell, SWT.None);
        b4.setText("b4");
        
        GridData gd0=new GridData();
        gd0.grabExcessHorizontalSpace=false;
        gd0.grabExcessVerticalSpace=false;
        gd0.heightHint=SWT.DEFAULT;
        gd0.verticalSpan=0;
        gd0.horizontalSpan=0;
        b0.setLayoutData(gd0);
        
        GridData gd1=new GridData();
        gd1.exclude=true;
        b1.setLayoutData(gd1);
        
        GridData gd2=new GridData();
        gd2.exclude=true;
        b2.setLayoutData(gd2);
        
        GridData gd3=new GridData();
        gd3.exclude=true;
        b3.setLayoutData(gd3);
        
        GridData gd4=new GridData();
        gd4.exclude=true;
        b4.setLayoutData(gd4);
        
        shell.open();
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}

}
