package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class F01Calendar {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setLayout(new GridLayout(3, false));

		DateTime calendar = new DateTime(shell, SWT.CALENDAR | SWT.DROP_DOWN | SWT.BORDER);
		DateTime date = new DateTime(shell, SWT.DATE | SWT.SHORT);
		DateTime time = new DateTime(shell, SWT.TIME | SWT.SHORT);
		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
