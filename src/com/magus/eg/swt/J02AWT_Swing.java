package com.magus.eg.swt;

import java.awt.Frame;

import javax.swing.JButton;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月14日
 */
public class J02AWT_Swing {

	public static void main(String[] args) {
		Frame frame=new Frame();
		JButton btn=new JButton("hi");
		frame.add(btn);
		frame.setVisible(true);
	}

}
