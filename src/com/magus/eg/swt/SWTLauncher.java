package com.magus.eg.swt;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTLauncher {
	public static void launch(SWTLaunchHandler e){
		Shell shell=new Shell();
		Display display=shell.getDisplay();
		shell.setLayout(new FillLayout());
		
		e.onLaunch(shell);
		
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		
        display.dispose();
	}
}
