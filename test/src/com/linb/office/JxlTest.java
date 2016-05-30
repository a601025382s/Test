package com.linb.office;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlTest {
    public static String testEx() {
        // a, 计算路径
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy-MM-dd/");
        String datePath = sdf.format(new Date());
        datePath = "中国石油西部管道输气量交接电子文档" + datePath;

        String path = "C:\\Users\\ucmed\\Desktop\\1.xlsx";

        try {
            WritableWorkbook wwb = Workbook.createWorkbook(new File(path));

            WritableSheet sheet1 = wwb.createSheet("前五个站队", 0);

            sheet1.setColumnView(0, 30); // 设置列的宽度
            sheet1.setColumnView(1, 30); // 设置列的宽度
            sheet1.setColumnView(2, 30); // 设置列的宽度
            sheet1.setColumnView(3, 30); // 设置列的宽度
            sheet1.setColumnView(4, 30); // 设置列的宽度
            sheet1.setColumnView(5, 30); // 设置列的宽度

            sheet1.setRowView(0, 1000); // 设置行的高度
            sheet1.setRowView(1, 500); // 设置行的高度

            /**
             * 定义单元格样式
             */
            WritableFont wf_title = new WritableFont(WritableFont.ARIAL,
                    20, WritableFont.BOLD, false,
                    UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED); // 定义格式
                                                                         // 字体
                                                                         // 下划线
                                                                         // 斜体
                                                                         // 粗体
                                                                         // 颜色
            WritableFont wf_head = new WritableFont(WritableFont.ARIAL,
                    10, WritableFont.BOLD, false,
                    UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN); // 定义格式
                                                                           // 字体
                                                                           // 下划线
                                                                           // 斜体
                                                                           // 粗体
                                                                           // 颜色
            WritableFont wf_table = new WritableFont(WritableFont.ARIAL,
                    8, WritableFont.BOLD, false,
                    UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK); // 定义格式
                                                                           // 字体
                                                                           // 下划线
                                                                           // 斜体
                                                                           // 粗体
                                                                           // 颜色

            WritableCellFormat wcf_title = new WritableCellFormat(wf_title); // 单元格定义
            wcf_title.setBackground(jxl.format.Colour.BLACK); // 设置单元格的背景颜色
            wcf_title.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式

            WritableCellFormat wcf_head = new WritableCellFormat(wf_head);
            wcf_head.setBackground(jxl.format.Colour.BLACK);
            wcf_head.setAlignment(jxl.format.Alignment.CENTRE);

            WritableCellFormat wcf_table = new WritableCellFormat(wf_table);
            wcf_table.setBackground(jxl.format.Colour.BLACK);
            wcf_table.setAlignment(jxl.format.Alignment.CENTRE);

            /**
             * 使用样式的单元格
             */
            // 1.添加Label对象三个参数意思：【列，行，值】
            sheet1.addCell(new Label(0, 0, "标题", wcf_title)); // 普通的带有定义格式的单元格
            sheet1.addCell(new Label(0, 1, "表头1", wcf_head));
            sheet1.addCell(new Label(1, 1, "表头2", wcf_head));
            sheet1.addCell(new Label(2, 1, "表头3", wcf_head));
            sheet1.addCell(new Label(3, 1, "表头4", wcf_head));
            sheet1.addCell(new Label(4, 1, "表头5", wcf_head));
            sheet1.addCell(new Label(5, 1, "表头6", wcf_head));

            sheet1.mergeCells(0, 0, 5, 0); // 合并单元格

            // 写入Exel工作表
            wwb.write();
            // 关闭Excel工作薄对象
            wwb.close();

        } catch(Exception e) {
            e.printStackTrace();
            return "0";
        }

        return path;
    }

    public static void main(String[] args) {
        System.out.println(JxlTest.testEx());
    }
}
