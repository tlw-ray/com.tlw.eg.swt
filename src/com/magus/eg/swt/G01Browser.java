package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Shell;

public class G01Browser {

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				Browser browser=new Browser(shell, SWT.None);
				browser.setUrl("www.baidu.com");
			}
		});
	}

}
