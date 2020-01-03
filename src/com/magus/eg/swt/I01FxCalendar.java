package com.magus.eg.swt;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Shell;

public class I01FxCalendar {

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			@Override
			public void onLaunch(Shell shell) {
				shell.setLayout(new RowLayout());
				FXCanvas fxCanvas=new FXCanvas(shell, SWT.NONE);
				DatePicker datePicker=new DatePicker();
				Scene scene=new Scene(datePicker);
				fxCanvas.setScene(scene);
			}
		});
	}
}
