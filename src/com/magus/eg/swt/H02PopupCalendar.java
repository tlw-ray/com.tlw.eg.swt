package com.magus.eg.swt;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class H02PopupCalendar {
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
						
						URL u=getClass().getResource("jscalendar-1.0/calendar.html");
						Browser browser=new Browser(dialog, SWT.NONE);
						GridData gridData=new GridData();
						gridData.grabExcessHorizontalSpace=true;
						gridData.grabExcessVerticalSpace=true;
						gridData.horizontalAlignment=SWT.FILL;
						gridData.verticalAlignment=SWT.FILL;
						browser.setLayoutData(gridData);
						browser.setUrl(u.toString());
						browser.addStatusTextListener(new StatusTextListener(){
							@Override
							public void changed(StatusTextEvent event) {
								System.out.println(event.text);
							}
						});
						
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
