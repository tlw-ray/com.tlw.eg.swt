package com.magus.eg.swt;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Shell;
//回调浏览器page.onload()事件
public class G05BrowserOnload {

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
