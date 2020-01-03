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
@since 2014年2月12日 上午9:46:26
 */
public class A02TreeTable {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		
		shell.setLayout(new FillLayout());
		
		Tree tree=new Tree(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setHeaderVisible(true);
		TreeColumn column1=new TreeColumn(tree, SWT.LEFT);
		column1.setText("Column1");
		column1.setWidth(200);
		TreeColumn column2=new TreeColumn(tree, SWT.CENTER);
		column2.setText("Column2");
		column2.setWidth(200);
		TreeColumn column3=new TreeColumn(tree, SWT.RIGHT);
		column3.setText("Column3");
		column3.setWidth(200);
		for(int i=0;i<4;i++){
			TreeItem item=new TreeItem(tree, SWT.NONE);
			item.setText(new String[]{"item"+i, "aaa"+i, "bbb"+i});
			for(int j=0;j<4;j++){
				TreeItem subItem=new TreeItem(item, SWT.NONE);
				subItem.setText(new String[]{"subitem"+j, "ccc"+j, "ddd"+j});
			}
		}
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(display.readAndDispatch()){
				display.sleep();
			}
		}
		shell.dispose();
	}

}
