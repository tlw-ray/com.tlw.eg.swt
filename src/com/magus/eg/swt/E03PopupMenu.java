package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
//菜单绑定在多控件
public class E03PopupMenu {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		Composite c1 = new Composite(shell, SWT.BORDER);
		c1.setSize(100, 100);
		Composite c2 = new Composite(shell, SWT.BORDER);
		c2.setBounds(100, 0, 100, 100);
		Menu menu = new Menu(shell, SWT.POP_UP);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Popup");
		c1.setMenu(menu);
		c2.setMenu(menu);
		shell.setMenu(menu);
		shell.setSize(300, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
