/**
 * 
 */
package com.magus.eg.swt.color;

import java.util.regex.Pattern;

import org.eclipse.swt.graphics.RGB;

/**
 * @author liucong
 *
 */
public class HexAndRGB {
	public static void main(String[] args){
		HexAndRGB testConvert = new HexAndRGB();
		String hex = "#FFGeCD";
		RGB rgb = testConvert.ConvertHexToRGB(hex);
		if(rgb  != null){
			System.out.println(rgb.red + "---" + rgb.green + "---" + rgb.blue);
			System.out.println(testConvert.ConvertRGBToHex(rgb));
		}
	}
	public RGB ConvertHexToRGB(String hex){
		RGB rgb = new RGB(0,0,0);
		String rStr = "";
		String gStr = "";
		String bStr = "";
		if(hex.substring(0, 1).equals("#")){
			if(hex.length() == 7){
				for(int i=1;i<7;i++){
					if(isHexNumber(hex.substring(i, i+1))){
						continue;
					}
					else{
						System.out.println("错误:转化的数据中包含非法字符" + "“" + hex.substring(i, i+1) +"”");
						return null;
					}						
				}
				rStr = hex.substring(1, 3);
				rgb.red = Integer.parseInt(rStr,16);
				gStr = hex.substring(3, 5);
				rgb.green = Integer.parseInt(gStr,16);
				bStr = hex.substring(5, 7);
				rgb.blue = Integer.parseInt(bStr,16);
			}
		}
		return rgb;
	}
	
	public String ConvertRGBToHex(RGB rgb){
		int r = rgb.red;
		int g = rgb.green;
		int b = rgb.blue;
		
		return "#" + toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
	}
	
	private String toBrowserHexValue(int number) {
		StringBuilder builder = new StringBuilder(
		Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}
		return builder.toString().toUpperCase();
	}
	
	private boolean isHexNumber(String a){
	    String regString = "[a-f0-9A-F]";
	    if (Pattern.matches(regString, a)){
	        //匹配成功
	    	return true;
	    }else
	    	return false;
	}
}

