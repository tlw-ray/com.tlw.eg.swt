package com.magus.eg.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class D02MessageBox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        MessageBox mb=new MessageBox(shell);
        mb.setText("hi");
        mb.open();
        System.out.println("opened");
        
        shell.open();
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}

}
