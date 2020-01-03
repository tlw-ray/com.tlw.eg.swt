package com.magus.eg.swt.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * 编辑表格数据
 * @author liwei
 *
 */

public class A02TableEdit extends Composite{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        
        shell.setLayout(new FillLayout());
        
        new A02TableEdit(shell, SWT.BORDER);
        
        shell.open();
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}
	Table table;
	TableEditor editor;
	ActionDelete actionDelete=new ActionDelete();
	public A02TableEdit(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		table=new Table(this, SWT.BORDER);
		editor = new TableEditor(table);
        TableColumn tc1 = new TableColumn(table, SWT.CENTER);
        TableColumn tc2 = new TableColumn(table, SWT.CENTER);
        TableColumn tc3 = new TableColumn(table, SWT.CENTER);
        tc1.setText("First Name");
        tc2.setText("Last Name");
        tc3.setText("Address");
        tc1.setWidth(170);
        tc2.setWidth(170);
        tc3.setWidth(180);
        table.setHeaderVisible(true);

        TableItem item1 = new TableItem(table, SWT.NONE);
        item1.setText(new String[] { "Tim", "Hatton", "Kentucky1" });
        TableItem item2 = new TableItem(table, SWT.NONE);
        item2.setText(new String[] { "Caitlyn", "Warner", "Ohio2" });
        TableItem item3 = new TableItem(table, SWT.NONE);
        item3.setText(new String[] { "Reese", "Miller", "Ohio3" });
        
        Composite composite=new Composite(this, SWT.None);
        composite.setLayout(new RowLayout());
        Button sbuttonCreate=new Button(composite, SWT.NONE);
        sbuttonCreate.setText("Create");
        Button sbuttonDelete=new Button(composite, SWT.NONE);
        sbuttonDelete.setText("Delete");
        
        sbuttonCreate.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int count=table.getItemCount();
				TableItem item=new TableItem(table, SWT.NONE);
				item.setText(new String[]{count+"","",""});
			}
        });
        sbuttonDelete.addSelectionListener(actionDelete);
        
        editor.grabHorizontal = true;
        
        table.addListener(SWT.MouseDoubleClick, new Listener(){
			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							final int column = i;
							final Text text = new Text(table, SWT.NONE);
							Listener textListener = new Listener() {
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, text.getText());
										text.dispose();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item.setText(column, text.getText());
										case SWT.TRAVERSE_ESCAPE:
											text.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};
							text.addListener(SWT.FocusOut, textListener);
							text.addListener(SWT.Traverse, textListener);
							editor.setEditor(text, item, i);
							text.setText(item.getText(i));
							text.selectAll();
							text.setFocus();
							return;
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
			}
		});
	}
	class ActionDelete extends SelectionAdapter{
		@Override
		public void widgetSelected(SelectionEvent e) {
			int selected=table.getSelectionIndex();
			if(selected>=0){
				MessageBox smessageBox=new MessageBox(getShell(), SWT.OK | SWT.CANCEL);
				smessageBox.setMessage("Delete");
				int result=smessageBox.open();
				if(result==SWT.OK){
					table.remove(selected);
				}
			}
		}
    }
}
