package com.linb.ppt;

import java.io.IOException;

import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;


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
		String ImgdestFile = "E:\\test\\pptImages\\";

		//获取返回码
		int Return = OfficeToPDF.office2PDF(inputFile, destFile);
		if (Return == -1) {
			System.out.println("找不着源文件呢 ");
		}else if (Return == 1) {
			System.out.println("转换失败");
		}else if(Return == 0){
			System.out.println("转换pdf成功");
/*			try {
			    System.out.println("开始转换图片-----------------------");
			    Long startTime = System.currentTimeMillis();
                Pdf2Jpg.tranfer(destFile, ImgdestFile);
                Long endTime = System.currentTimeMillis();
                System.out.println("转换图片成功，总耗时：" + (endTime - startTime) + "ms");
            } catch(PDFException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch(PDFSecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch(IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }	*/
		}
		System.out.println("ppt转换程序结束");
	}
}
