package com.linb.office;

import com.linb.office.OfficeToPDF;


public class Entry {

	/**
	 * @param args
	 */
	public static void main(String[]arg0){
		//Office源文件(word,excel,ppt)
		String inputFile = "E:\\test\\test.pptx";
		//目标文件（准备存进哪里）
		String destFile = "E:\\test\\test.pdf";
		//Img目标文件（图片存储地方）
		// String ImgdestFile = "E:\\test\\pptImages";

		//获取返回码
		int Return = OfficeToPDF.office2PDF(inputFile, destFile);
		if (Return == -1) {
			System.out.println("找不着源文件呢 ");
		}else if (Return == 1) {
			System.out.println("转换失败");
		}else if(Return == 0){
			System.out.println("转换成功");
		}
		System.out.println("4567");
	}
}
