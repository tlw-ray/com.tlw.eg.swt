package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class H01PopupDialog {

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				shell.setLayout(new RowLayout());
				
				Button button=new Button(shell, SWT.NONE);
				button.setText("Calendar");
				button.addSelectionListener(new SelectionListener(){
					@Override
					public void widgetSelected(SelectionEvent e) {
						Display display=shell.getDisplay();
						Shell dialog=new Shell(display);
						dialog.open();
						while(!dialog.isDisposed()){
							if(!display.readAndDispatch()){
								display.sleep();
							}
						}
					}
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						
					}
				});
				

			}
		});
	}

}
