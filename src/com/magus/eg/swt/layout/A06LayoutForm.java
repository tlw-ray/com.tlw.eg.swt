package com.magus.eg.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class A06LayoutForm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        FormLayout formLayout=new FormLayout();
        shell.setLayout(formLayout);
        
        System.out.println(shell.getBounds());
        
        Button b0=new Button(shell, SWT.NONE);
        b0.setText("b0");
        Button b1=new Button(shell, SWT.NONE);
        b1.setText("b1");
        Button b2=new Button(shell, SWT.NONE);
        b2.setText("b2");
        Button b3=new Button(shell, SWT.NONE);
        b3.setText("b3");
        Button b4=new Button(shell, SWT.NONE);
        b4.setText("b4");
        
        FormData fd0=new FormData();
        fd0.left=new FormAttachment(20,0);
        b0.setLayoutData(fd0);
        
        FormData fd1=new FormData();
        fd1.left=new FormAttachment(40,10);
        b1.setLayoutData(fd1);
        
        FormData fd2=new FormData();
        b2.setLayoutData(fd2);
        
        FormData fd3=new FormData();
        fd3.left=new FormAttachment(40,0);
        b3.setLayoutData(fd3);
        
        FormData fd4=new FormData();
        fd4.left=new FormAttachment(80,0);
        fd4.top=new FormAttachment(20,0);
        b4.setLayoutData(fd4);
        
        shell.pack();
        shell.open();
        
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}

}
