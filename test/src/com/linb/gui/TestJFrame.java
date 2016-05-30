package com.linb.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestJFrame {
    
    private static JTextField jtf = new JTextField(10);
    public static void main(String[] args) {
        JFrame jf = new JFrame("first JFrame");  
        jf.setLayout(new FlowLayout());
        // 添加标签
        JLabel label = new JLabel();
        label.setText("this is a label");
        jf.add(label);
        // 添加按钮
        JButton btn = new JButton("my button");
        jf.add(btn);
        // 文本框
        jtf.setText("初始化内容");
        jf.add(jtf);
        
        // 添加按钮事件
        btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("按钮被点击了");
            }
        });
        
        showMe(jf);
    }
    
    private static void showMe(JFrame jf) {
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 400);
        jf.setVisible(true);
    }
}
