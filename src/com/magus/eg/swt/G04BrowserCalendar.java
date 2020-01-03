package com.magus.eg.swt;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.widgets.Shell;

public class G04BrowserCalendar {
	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				URL u=getClass().getResource("jscalendar-1.0/calendar.html");
				Browser browser=new Browser(shell, SWT.NONE);
				browser.setUrl(u.toString());
				shell.setSize(228,196);
				
				browser.addStatusTextListener(new StatusTextListener(){
					@Override
					public void changed(StatusTextEvent event) {
						System.out.println(event.text);
					}
				});
			}
		});
	}

}
