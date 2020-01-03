package com.magus.eg.swt.table;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
//将该渲染器添加到TableColumn上即可使该TableColumn显示行号
//例如:table.getColumn(0).addListener(SWT.SetData, new RowNumberRenderer());
public class RowNumberRenderer implements Listener {
	@Override
	public void handleEvent(Event event) {
		TableItem item = (TableItem) event.item;
		Table table=item.getParent();
		int rowIndex=table.indexOf(item);
		item.setText(rowIndex+"");
		System.out.println("...");
	}

}
