package com.magus.eg.swt.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author liwei.tang@magustek.com
 * @since 2014年7月11日
 * SWT表格的最基础用法
 */
public class A01TableItem {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		
		//Full selection is row selection.
		Table table = new Table(shell, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);

		// 建立表头
		int columnCount=3;
		for(int i=0;i<columnCount;i++){
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setText("Column"+i);
			tableColumn.setToolTipText("Column"+i+" tooltip");
			tableColumn.setWidth(200);
		}

		// 建立表内容
		for (int i = 0; i < 100; i++) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			for(int j=0;j<columnCount;j++){
				tableItem.setText(j, "Item"+j);
			}
		}

		shell.open();
		while (!shell.isDisposed()) {
			if (display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
