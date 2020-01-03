package com.magus.eg.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.magus.eg.swt.SWTLaunchHandler;
import com.magus.eg.swt.SWTLauncher;

/**
 * @Author liwei.tang@magustek.com
 * @since 2014年9月10日上午11:08:49
 **/
public class A02CustomDialog extends Dialog implements SelectionListener{

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				A02CustomDialog dialog = new A02CustomDialog(shell, SWT.NONE);
				dialog.setText("Dialog");
				Object result=dialog.open();
				System.out.println(result);
			}
		});
	}
	
	public A02CustomDialog(Shell parent, int style) {
		super(parent, style);
	}
	Button btnOK;
	Button btnCancel;
	Shell shell;
	Object result;
	public Object open() {
		Shell parent = getParent();
		shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(getText());
		shell.setSize(400, 300);
		shell.setLayout(new RowLayout());
		btnOK=new Button(shell, SWT.NONE);
		btnOK.setText("OK");
		btnOK.addSelectionListener(this);
		btnCancel=new Button(shell, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(this);
		
		shell.open();
		Display display = parent.getDisplay();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		return result;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource()==btnOK){
			result="OK";
		}else{
			result="CANCEL";
		}
		shell.close();
		shell.dispose();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		
	}
}
