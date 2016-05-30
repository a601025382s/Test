package com.linb.office;
import java.awt.Color;
import java.awt.Font;  
import java.awt.image.BufferedImage;  
import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;  
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;  
import org.apache.poi.hssf.usermodel.HSSFPatriarch;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;  
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;  
import org.jfree.chart.title.TextTitle;  
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.ui.TextAnchor;
/** 
 * 由JFreeChart生成图片放到硬盘上  
 * 对于Swing程序可以由org.jfree.chart.ChartUtilities类完成图片的生成 
 *  
 * @author  
 *  
 */  
public class JFreeChartTest2 {  
    public static void main(String[] args) {
        List<String[]> data = new ArrayList<String[]>();
        String[] s1 = { "30", "上海", "2016" };
        String[] s2 = { "45", "上海", "2017" };
        String[] s3 = { "50", "上海", "2018" };
        String[] s4 = { "63", "上海", "2019" };
        String[] s5 = { "77", "上海", "2020" };
        String[] s6 = { "-1.5", "上海", "2021" };
//        String[] z1 = { "25", "上海", "2010" };
//        String[] z2 = { "30", "上海", "2011" };
//        String[] z3 = { "5", "上海", "2012" };
//        String[] z4 = { "60", "上海", "2013" };
//        String[] z5 = { "30", "上海", "2014" };
//        String[] z6 = { "50", "上海", "2015" };
        data.add(s1);
        data.add(s2);
        data.add(s3);
        data.add(s4);
        data.add(s5);
        data.add(s6);
//        data.add(z1);
//        data.add(z2);
//        data.add(z3);
//        data.add(z4);
//        data.add(z5);
//        data.add(z6);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String[] ss : data) {
            dataset.addValue(Double.valueOf(ss[0]), ss[1], ss[2]);
        }
        JFreeChart chart = ChartFactory.createLineChart("测试图", // chart title
                "年份", // domain axis label
                "吨", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
                );
        setImageFont(chart);
        CategoryPlot line = chart.getCategoryPlot();
        // 设置条目标签（节点数据）的样式
        CategoryItemRenderer renderer = line.getRenderer();
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BASELINE_LEFT)); // 位置，ItemLabelAnchor表示条目标签的位置,TextAnchor表示文本位置
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00"))); // 数据格式， {2}表示纵坐标数据，1表示横坐标，0分类名称
        renderer.setBaseItemLabelFont(new Font("Dialog", Font.BOLD, 15)); // 字体
        renderer.setBaseItemLabelPaint(Color.BLUE); // 颜色
        line.setRenderer(renderer);
        // 纵坐标样式
        NumberAxis rangeAxis = (NumberAxis) line.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        rangeAxis.setUpperMargin(0.2);
        rangeAxis.setLabelAngle(Math.PI / 2.0);
        line.setRangeAxis(rangeAxis);
        
        
        ChartFrame chartFrame = new ChartFrame("某公司人员组织数据图", chart);
        // chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
        chartFrame.pack(); // 以合适的大小展现图形
        chartFrame.setVisible(true);// 图形是否可见
    }
    
    /**
     * 解决乱码问题
     */
    private static void setImageFont(JFreeChart chart) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        ValueAxis numberaxis = plot.getRangeAxis();

        // 设置标题文字
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 12));

        // 设置X轴坐标上的文字
        domainAxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 11));

        // 设置X 轴的标题文字
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));

        // 设置Y 轴坐标上的文字
        numberaxis
                .setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

        // 设置Y 轴的标题文字
        numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));

        // 设置底部文字
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
    }
}  