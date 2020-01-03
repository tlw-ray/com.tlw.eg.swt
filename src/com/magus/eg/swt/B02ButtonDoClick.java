package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

/**
@author liwei.tang@magustek.com
@since 2014年7月14日
 */
public class B02ButtonDoClick {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setLayout(new FillLayout());
		
		
		
		final Button button1=new Button(shell, SWT.NONE);
		button1.setText("Button1");
		button1.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("button1 selected");
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("button1 default selected");
			}
		});
		
		
		
		Button button2=new Button(shell, SWT.NONE);
		button2.setText("Button2");
		button2.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("button2 selected");
				button1.notifyListeners(SWT.Selection, new Event());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("button2 selected");
			}
		});
		
		
		
		
		shell.setDefaultButton(button1);
		shell.open();
		while(!shell.isDisposed()){
			if(display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}

}
