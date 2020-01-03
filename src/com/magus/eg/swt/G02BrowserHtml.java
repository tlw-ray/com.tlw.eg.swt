package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.widgets.Shell;

public class G02BrowserHtml {

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				Browser browser=new Browser(shell, SWT.None);
				
//				URL u=getClass().getResource("Test.html");
//				browser.setUrl(u.toString());
				
				
				browser.setText("<h1>Hello</h1>");
				
				
				System.out.println("URL: "+browser.getUrl());
				System.out.println("HTML: "+browser.getText());
				
				//Listen browser event.
				browser.addCloseWindowListener(new CloseWindowListener(){
					@Override
					public void close(WindowEvent event) {
						System.out.println(event);
					}
				});
			}
		});
	}

}
