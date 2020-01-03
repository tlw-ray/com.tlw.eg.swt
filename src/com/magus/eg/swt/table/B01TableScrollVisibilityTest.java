package com.magus.eg.swt.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * @author liwei.tang@magustek.com
 * @since 2016年3月24日
 */
public class B01TableScrollVisibilityTest {
	private static int count;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setBounds(10, 10, 300, 300);
		shell.setLayout(new GridLayout(2, true));

		final Table table = new Table(shell, SWT.NONE);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		table.setLayoutData(data);

		count = 0;

		final Button addItem = new Button(shell, SWT.PUSH);
		addItem.setText("Add Row");
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.horizontalSpan = 2;
		addItem.setLayoutData(data);

		final Text text = new Text(shell, SWT.BORDER);
		text.setText("Vertical Scroll Visible - ");
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.horizontalSpan = 2;
		text.setLayoutData(data);

		addItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				new TableItem(table, SWT.NONE).setText("item " + count);
				count++;
			}
		});

		table.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Rectangle rect = table.getClientArea();
				int itemHeight = table.getItemHeight();
				int headerHeight = table.getHeaderHeight();
				int visibleCount = (rect.height - headerHeight + itemHeight - 1) / itemHeight;
				text.setText("Vertical Scroll Visible - [" + (table.getItemCount() >= visibleCount) + "]");

				// YOUR CODE HERE
				ScrollBar scrollBar = table.getVerticalBar();
				System.out.println("min:" + scrollBar.getMinimum());
				System.out.println("max:" + scrollBar.getMaximum());
				System.out.println("selection:" + scrollBar.getSelection());
				System.out.println("increment:" + scrollBar.getIncrement());
				System.out.println("tableHeight:" + table.getSize().y);
				System.out.println("tableItemHeight:" + table.getItemHeight());
				
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}

}
