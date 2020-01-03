package com.magus.eg.swt.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.magus.eg.swt.SWTLaunchHandler;
import com.magus.eg.swt.SWTLauncher;

/**
 * @Author liwei.tang@magustek.com
 * @since 2014年9月1日上午11:11:34
 **/
public class A04TableEditor {

	public static void main(String[] args) {
		SWTLauncher.launch(new SWTLaunchHandler(){
			
			TableEditor editor;
			Text text;
			TableItem item;
			
			@Override
			public void onLaunch(Shell shell) {
				shell.setLayout(new RowLayout());
				final Table table = new Table(shell, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
				TableColumn column1 = new TableColumn(table, SWT.NONE);
				TableColumn column2 = new TableColumn(table, SWT.NONE);
				for (int i = 0; i < 10; i++) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(new String[] {"item " + i, "edit this value"});
				}
				column1.pack();
				column2.pack();
				
				editor = new TableEditor(table);
				//The editor must have the same size as the cell and must
				//not be any smaller than 50 pixels.
				editor.horizontalAlignment = SWT.LEFT;
				editor.grabHorizontal = true;
				editor.minimumWidth = 50;
				// editing the second column
				final int EDITABLECOLUMN = 1;
				
				table.addListener(SWT.MouseDoubleClick, new Listener() {
					@Override
					public void handleEvent(Event event) {
						// Clean up any previous editor control
						Control oldEditor = editor.getEditor();
						if (oldEditor != null) oldEditor.dispose();
				
						// Identify the selected row
						item = table.getItem(new Point(event.x, event.y));
						if (item == null) return;
				
						// The control that will be the editor must be a child of the Table
						text = new Text(table, SWT.NONE);
						text.setText(item.getText(EDITABLECOLUMN));
						text.addModifyListener(new ModifyListener() {
							@Override
							public void modifyText(ModifyEvent me) {
								Text text = (Text)editor.getEditor();
								editor.getItem().setText(EDITABLECOLUMN, text.getText());
							}
						});
						text.selectAll();
						text.setFocus();
						editor.setEditor(text, item, EDITABLECOLUMN);
					}
				});
				
				Button button=new Button(shell, SWT.NONE);
				button.setText("取消编辑");
				button.addSelectionListener(new SelectionListener(){
					@Override
					public void widgetSelected(SelectionEvent e) {
						if(item!=null && text!=null){
							text.dispose();
						}
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						
					}
				});
			}
		});
	}

}
