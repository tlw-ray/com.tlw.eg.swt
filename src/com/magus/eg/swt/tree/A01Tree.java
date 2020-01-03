package com.magus.eg.swt.tree;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

/**
@author liwei.tang@magustek.com
@since 2014年2月13日 下午12:53:25
 */
public class A01Tree {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		
		//set the shell layout
		shell.setLayout(new FillLayout());
		
		//create tree widget
		Tree tree=new Tree(shell, SWT.NONE);
		
		TreeColumn treeColumn=new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(150);
		
		TreeItem itemRoot=new TreeItem(tree, SWT.NONE);
		itemRoot.setText("Root");
		TreeItem item1=new TreeItem(itemRoot, SWT.NONE);
		item1.setText("Child1");
		TreeItem item2=new TreeItem(itemRoot, SWT.NONE);
		item2.setText("Child2");
		
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}
}
