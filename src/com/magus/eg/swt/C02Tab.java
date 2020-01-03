package com.magus.eg.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class C02Tab extends Composite{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        shell.setLayout(new FillLayout());
        
        final TabFolder tabFolder=new TabFolder(shell, SWT.NONE);
        TabItem tabItem1=new TabItem(tabFolder, SWT.NONE);
        tabItem1.setText("text1");
        TabItem tabItem2=new TabItem(tabFolder, SWT.NONE);
        tabItem2.setText("text2");
        
        tabFolder.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(tabFolder.getSelection()[0]);
			}
        });
        
        
        Label label=new Label(tabFolder, SWT.NONE);
        label.setText("aaa");
        tabItem1.setControl(label);
        
        shell.open();
        while(!shell.isDisposed()) {
           if(!display.readAndDispatch()) {
                  display.sleep();
           }
        }
        display.dispose();
	}

	public C02Tab(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

}
