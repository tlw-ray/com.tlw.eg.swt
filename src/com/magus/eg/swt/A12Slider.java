package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月14日
 */
public class A12Slider {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		// Slider
		final Slider slider = new Slider(shell, SWT.HORIZONTAL);
		slider.setBounds(10, 10, 200, 32);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setThumb(5);
		slider.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Slider Selection:" + slider.getSelection());
			}
		});

		// Scale
		final Scale scale = new Scale(shell, SWT.HORIZONTAL);
		scale.setBounds(10, 50, 200, 72);
		scale.setMinimum(0);
		scale.setMaximum(100);
		scale.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Scale Selection:" + scale.getSelection());
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
