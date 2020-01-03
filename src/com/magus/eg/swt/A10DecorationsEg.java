package com.magus.eg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月14日
 */
public class A10DecorationsEg {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Decorations One");
		shell.setLayout(new GridLayout(1, true));
		final Canvas canvas = new Canvas(shell, SWT.NONE);

		canvas.setLayoutData(new GridData(GridData.FILL_BOTH));
		Decorations d = new Decorations(canvas, SWT.CLOSE | SWT.RESIZE);
		d.setLayoutData(new GridData(GridData.FILL_BOTH));
		d.setLayout(new FillLayout());
		d.setText("TestDecorations");
		Label l = new Label(d, SWT.CENTER);
		l.setText("SWT.TOOL");
		d.setLocation(50, 50);
		d.pack();
		
		Decorations decorations = new Decorations(canvas, SWT.CLOSE | SWT.RESIZE);
		decorations.setText("Hi");
		decorations.setLocation(100, 200);

		Button button = new Button(canvas, SWT.PUSH);
		button.setText("button");
		button.setBounds(20, 20, 50, 20);
		System.out.println("button 之前控件数： " + canvas.getChildren().length);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseDown(MouseEvent e) {
				//似乎不能动态创建
				Decorations d1 = new Decorations(canvas, SWT.CLOSE | SWT.RESIZE | SWT.ON_TOP);
				d1.setLayoutData(new GridData(GridData.FILL_BOTH));
				d1.setLayout(new FillLayout());
				d1.setText("Decorations d1");
				Label l1 = new Label(d1, SWT.CENTER);
				l1.setText("Decorations d1 Label");
				d1.setLocation(80, 80);
				d1.setSize(300, 300);
				d1.pack();

				System.out.println("button 之后控件数： " + canvas.getChildren().length);
				System.out.println("button后 " + d1.getText() + " X: " + d1.getLocation().x + " Y: " + d1.getLocation().y);
				System.out.println();
			}

			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
