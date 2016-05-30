package com.linb.ppt;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @ClassName PptConvertTest 通过jacob进行ppt转换测试
 * @Description
 * @author linbao
 * @date 2015年6月12日 上午10:08:56
 */
public class PptConvertTest {

    final static int wdFormatPDF = 17; // word保存为pdf格式宏，值为17
    final static int pptFormatImg = 17; // ppt保存为图片格式宏，值为17？自己猜测，正确性未知；16为gif,17是jpg，18是png,19bmp
    final static int PPT_TO_PDF = 32;

    public static void main(String[] args) {
        String inputFile = "E:/test/test.pptx";
        String outputFile = "E:/test/test.jpg";
        String pdfFile = "E:\\test\\test2.pdf";
        String imageDir = "E:\\test\\test2\\";
        File file = new File("E:/test/test/test");
        System.out.println(file.listFiles().length);
        try {
            Long startTime = System.currentTimeMillis();
            // ppt2IMG(inputFile, outputFile);
            test(inputFile, outputFile);
            // pptToPdf(inputFile, pdfFile);
            // Pdf2Jpg.tranfer(pdfFile, imageDir);
            Long endTime = System.currentTimeMillis();
            System.out.println("总耗时：" + (endTime - startTime) + "ms");
        } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test(String inputFile, String outputFile) {
        String imagePath = outputFile.substring(0,
                outputFile.lastIndexOf("/") + 1);
        File imageDir = new File(imagePath);
        if (!imageDir.exists()) {
            imageDir.mkdirs();
        }
        // 打开word应用程序
        System.out.println("打开ppt应用");
        // ActiveXComponent app = new ActiveXComponent("Word.Application");
        ActiveXComponent app = new ActiveXComponent(
                "PowerPoint.Application");
        // 设置word不可见
        System.out.println("设置可见性");
        app.setProperty("Visible", false);
        // 获取word中国所打开的文档，返回Documents对象
        try {
            System.out.println("打开ppt文件");
            Dispatch files = app.getProperty("Presentations").toDispatch();
            // Dispatch docs = app.getProperty("Documents").toDispatch();
            // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
            Dispatch file = Dispatch.call(files, "open", inputFile, false,
                    true).toDispatch();
            // 调用Document对象的SaveAs方法，将文档保存为pdf格式
            System.out.println("保存为图片-----------");
            // Dispatch.call(doc, "ExportAsFixedFormat", outputFile,
            // PPT_TO_PDF);
            Dispatch.call(file, "SaveAs", outputFile, 17);
            // 关闭文档
            System.out.println("关闭文档");
            // Dispatch.call(file, "Close", false);
            Dispatch.call(file, "Close");
        } catch(Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw e;
        } finally {
            // 关闭word应用程序
            System.out.println("关闭应用");
            // app.invoke("Quit", 0);
            app.invoke("Quit");

        }
    }

    public static void pptToPdf(String inputFile, String outputFile) {
        // 打开word应用程序
        System.out.println("打开ppt应用");
        // ActiveXComponent app = new ActiveXComponent("Word.Application");
        ActiveXComponent app = new ActiveXComponent(
                "PowerPoint.Application");
        // 设置word不可见
        System.out.println("设置可见性");
        // app.setProperty("Visible", false);
        // 获取word中国所打开的文档，返回Documents对象
        System.out.println("打开ppt文件");
        Dispatch files = app.getProperty("Presentations").toDispatch();
        // Dispatch docs = app.getProperty("Documents").toDispatch();
        // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
        Dispatch file = Dispatch.call(files, "open", inputFile, false,
                true).toDispatch();
        // 调用Document对象的SaveAs方法，将文档保存为pdf格式
        System.out.println("保存为pdf-----------");
        // Dispatch.call(doc, "ExportAsFixedFormat", outputFile, PPT_TO_PDF);
        Dispatch.call(file, "SaveAs", outputFile, 32);
        // 关闭文档
        System.out.println("关闭文档");
        // Dispatch.call(file, "Close", false);
        Dispatch.call(file, "Close");
        // 关闭word应用程序
        System.out.println("关闭应用");
        // app.invoke("Quit", 0);
        app.invoke("Quit");
    }

    public static void pdfToImg(String inputFile, String outputFile) {
        // 打开word应用程序
        System.out.println("打开pdf应用");
        // ActiveXComponent app = new ActiveXComponent("Word.Application");
        // ActiveXComponent app = new
        // ActiveXComponent("PowerPoint.Application");
        ActiveXComponent app = new ActiveXComponent("AcroExch.PDDoc");
        // 设置word不可见
        System.out.println("设置可见性");
        // app.setProperty("Visible", false);
        // 获取word中国所打开的文档，返回Documents对象
        System.out.println("打开pdf文件");
        Dispatch files = app.getProperty("Presentations").toDispatch();
        // Dispatch files = app.getProperty("Documents").toDispatch();
        // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
        Dispatch file = Dispatch.call(files, "open", inputFile, false,
                true).toDispatch();
        // 调用Document对象的SaveAs方法，将文档保存为pdf格式
        System.out.println("保存为图片-----------");
        // Dispatch.call(doc, "ExportAsFixedFormat", outputFile, PPT_TO_PDF);
        for (int i = 0; i < 50; i++) {
            try {
                Dispatch.call(file, "SaveAs", outputFile, i);
            } catch(Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                continue;
            }
            System.out.println("PDF_IMAGE is " + i);
        }

        // 关闭文档
        System.out.println("关闭文档");
        // Dispatch.call(file, "Close", false);
        Dispatch.call(file, "Close");
        // 关闭word应用程序
        System.out.println("关闭应用");
        // app.invoke("Quit", 0);
        app.invoke("Quit");
    }

    /**
     * @Description word转换pdf
     * @param inputFile
     *            word文件绝对路径
     * @param pdfFile
     *            ppt文件绝对路径
     */
    public static void word2PDF(String inputFile, String pdfFile) {
        // 打开word应用程序
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        // 设置word不可见
        app.setProperty("Visible", false);
        // 获取word中国所打开的文档，返回Documents对象
        Dispatch docs = app.getProperty("Documents").toDispatch();
        // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
        Dispatch doc = Dispatch.call(docs, "open", inputFile, false, true)
                .toDispatch();
        // 调用Document对象的SaveAs方法，将文档保存为pdf格式
        Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF);
        // 关闭文档
        Dispatch.call(doc, "Close", false);
        // 关闭word应用程序
        app.invoke("Quit", 0);
    }

    /**
     * @Description ppt转换图片
     * @param inputFile
     *            ppt文件绝对路径
     * @param imgFile
     *            图像文件绝对路径
     * @throws Exception
     */
    public static void ppt2IMG(String inputFile, String imgFile)
            throws Exception {
        // 打开ppt应用程序
        System.out.println("打开ppt应用");
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        // ActiveXComponent app = new
        // ActiveXComponent("PowerPoint.Application");
        // 设置ppt不可见或可见
        System.out.println("设置可见性");
        // setIsVisble(app, false);
        // app.setProperty("Visible", new Variant(false));
        // 获取ppt中所打开的文档，返回Presentations对象
        System.out.println("打开ppt文件");
        Dispatch ppts = app.getProperty("Presentations").toDispatch();
        // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Presentation
        Dispatch ppt = Dispatch.call(ppts, "open", inputFile, false, true)
                .toDispatch();
        // 调用Document对象的SaveCopyAs方法，将文档保存为pdf格式
        System.out.println("保存为图片-----------");
        Dispatch.call(ppt, "SaveAs", imgFile, 17);
        // 关闭文档
        System.out.println("关闭文档");
        Dispatch.call(ppt, "Close");
        // 关闭word应用程序
        System.out.println("关闭应用");
        app.invoke("Quit");
    }

    /**
     * 设置是否可见
     * @param visble
     * @param obj
     */
    private static void setIsVisble(Dispatch obj, boolean visble)
            throws Exception {
        Dispatch.put(obj, "Visible", new Variant(visble));
    }

    private static void pptToImageByWPS(String pptPath, String ImagePath) {
        File pptFile = new File(pptPath);
        File ImageFile = new File(ImagePath);
        ActiveXComponent wps = null;
        try {
            wps = new ActiveXComponent("PowerPoint.application");
            ActiveXComponent doc = wps.invokeGetComponent("Documents")
                    .invokeGetComponent("Open",
                            new Variant(pptFile.getAbsolutePath()));
            doc.invoke("ExportPdf",
                    new Variant(ImageFile.getAbsolutePath()));
            doc.invoke("Close");
            doc.safeRelease();
        } catch(Exception ex) {
            // Logger.getLogger(Doc2Pdf.class.getName()).log(Level.SEVERE, null,
            // ex);
            ex.printStackTrace();
        } catch(Error ex) {
            // Logger.getLogger(Doc2Pdf.class.getName()).log(Level.SEVERE, null,
            // ex);
            ex.printStackTrace();
        } finally {
            if (wps != null) {
                wps.invoke("Terminate");
                wps.safeRelease();
            }
        }
    }
}