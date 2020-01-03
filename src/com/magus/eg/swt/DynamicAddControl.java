package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月14日
 */
public class DynamicAddControl {

	public static void main(String[] args) {
		
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				RowLayout rowLayout=new RowLayout();
				shell.setLayout(rowLayout);
				
				Decorations decx=new Decorations(shell, SWT.CLOSE | SWT.RESIZE | SWT.ON_TOP);
				decx.setText("decorations");
				
				Button btn=new Button(shell, SWT.NONE);
				btn.setText("create");
				
				btn.addSelectionListener(new SelectionListener(){
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						
					}
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						Button buttonx=new Button(shell, SWT.NONE);
						buttonx.setText("btnx");
						
						Decorations dec=new Decorations(shell, SWT.CLOSE | SWT.RESIZE | SWT.ON_TOP);
						dec.setText("decorations");
						Label label=new Label(dec, SWT.NONE);
						label.setText("label");
						
						shell.layout();
						shell.redraw();
					}
				});
			}
		});
		
	}

}
