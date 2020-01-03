package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
//最简单的菜单代码
public class E02PopupMenu {

	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        Menu menu=new Menu(shell, SWT.POP_UP);
        
        MenuItem menuItem=new MenuItem(menu, SWT.PUSH);
        menuItem.setText("MenuItem");
        
        shell.setMenu(menu);
        shell.setSize(400,300);
        shell.open();
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}

}
