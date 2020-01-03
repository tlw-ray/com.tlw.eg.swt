package com.magus.eg.swt;

import java.awt.Frame;

import javax.swing.JButton;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年7月27日
 */
public class J01Swing {

	public static void main(String[] args) {
		final Display display = Display.getDefault();

		final Shell shell = new Shell();

		shell.setSize(400, 300);
		
		shell.setLayout(new FillLayout());
		
		Composite comp = new Composite(shell, SWT.EMBEDDED | SWT.LINE_SOLID);// 必须有SWT.EMBEDDED
		comp.setLayout(new FillLayout());

		Frame frame = SWT_AWT.new_Frame(comp);// 只能放frame不能放JFrame
		JButton jbutton=new JButton("Swing");
		frame.add(jbutton);

		shell.open();

		while (!shell.isDisposed()) {

			if (!display.readAndDispatch())

				display.sleep();

		}

	}

}
