package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.PopupList;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
//popup list 包含独立的shell，使用while(!shell.isDisposed() && shell.isVisible)来维持其存在。
public class H03PopupList {

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				Button button=new Button(shell, SWT.NONE);
				button.setText("Popup");

				button.addSelectionListener(new SelectionListener(){
					@Override
					public void widgetSelected(SelectionEvent e) {
						PopupList popupList=new PopupList(shell);
						popupList.setItems(new String[]{"aaa","bbb","ccc"});
						String selected=popupList.open(new Rectangle(50,50, 100, 100));
						System.out.println(selected);
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
			}
		});
		
	}

}
