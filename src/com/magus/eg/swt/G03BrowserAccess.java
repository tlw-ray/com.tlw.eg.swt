package com.magus.eg.swt;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

public class G03BrowserAccess {

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				shell.setLayout(new RowLayout());
				URL u=getClass().getResource("Test.html");
				System.out.println(u);
				Browser browser=new Browser(shell, SWT.NONE);
				browser.setUrl(u.toString());
				browser.setLayoutData(new RowData(400, 300));
				
				//set HTML element value;
				Button buttonSet=new Button(shell, SWT.NONE);
				buttonSet.setText("setValue");
				buttonSet.addSelectionListener(new SelectionListener(){

					@Override
					public void widgetSelected(SelectionEvent e) {
						browser.execute("text01.value='abc'");
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						
					}
					
				});
				
				
				//注意：通过对进度条的监听实现对页面加载完毕时的回调，例如设定页面某属性值。
				browser.addProgressListener(new ProgressListener() {
					@Override
					public void completed(ProgressEvent event) {
						System.out.println(event);
						browser.execute("window.onload=alert('programOnload'+text01.value);");
					}
					@Override
					public void changed(ProgressEvent event) {
						System.out.println(event);
					}
				});
				
				
				
				//Get HTML element value;
				browser.addStatusTextListener(new StatusTextListener(){
					@Override
					public void changed(StatusTextEvent event) {
						browser.setData("query", event.text);
					}
				});
				
				
				
				Button buttonGet=new Button(shell, SWT.NONE);
				buttonGet.setText("getValue");
				buttonGet.addSelectionListener(new SelectionListener(){
					@Override
					public void widgetSelected(SelectionEvent e) {
						boolean result = browser.execute("window.status=document.getElementById('text01').value;");
						if (!result) {
							/* Script may fail or may not be supported on certain platforms. */
				        	System.out.println("Script was not executed.");
				        	return;
				        }
				        String value = (String) browser.getData("query");
				        System.out.println("Node value: " + value);
					}
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						
					}
				});
				
				
				
				//Listen browser event, when close button clicked. Output HTML element value.
				browser.addCloseWindowListener(new CloseWindowListener(){
					@Override
					public void close(WindowEvent event) {
						System.out.println(event);
						System.out.println(browser.evaluate("text01.value"));
					}
				});
			}
		});
	}

}
