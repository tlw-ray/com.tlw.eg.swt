package com.magus.eg.swt.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
@author liwei.tang@magustek.com
@since 2014年7月11日
 */
public class A03TableCellSelection {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		
		final Table table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		table.setHeaderVisible(true);
		
		table.addListener(SWT.EraseItem, new Listener() {
		     public void handleEvent(Event event) {
		        event.detail &= ~SWT.HOT;
		        if ((event.detail & SWT.SELECTED) == 0) 
		          return; 
		        int clientWidth = ((Composite)event.widget).getClientArea().width;
		        GC gc = event.gc;
		        Color oldForeground = gc.getForeground();
		        Color oldBackground = gc.getBackground();
		        gc.setBackground(event.display.getSystemColor(SWT.COLOR_YELLOW));
		        gc.setForeground(event.display.getSystemColor(SWT.COLOR_BLUE));
		        gc.fillGradientRectangle(0, event.y, clientWidth, event.height, true);
		        gc.setForeground(oldForeground);
		        gc.setBackground(oldBackground);
		        event.detail &= ~SWT.SELECTED;
		     }
		  });

		
//	    table.addListener(SWT.MouseDown, new Listener(){
//	        public void handleEvent(Event event){
//	            Point pt = new Point(event.x, event.y);
//	            TableItem item = table.getItem(pt);
//	            if(item != null) {
//	                for (int col = 0; col < table.getColumnCount(); col++) {
//	                	//输出选中的cell;
//	                    Rectangle rect = item.getBounds(col);
//	                    if (rect.contains(pt)) {
//	                        System.out.println("item clicked.");
//	                        System.out.println("column is " + col);
//	                    }
//	                }
//	            }
//	        }
//	    });


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
