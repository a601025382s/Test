package com.linb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @ClassName Mine
 * @Description 扫雷游戏
 * @author linb
 * @date 2016年3月23日 下午1:34:05
 */
public class Mine extends MouseAdapter {
    private JFrame mainFrame; // 窗口
    private int[][] data; // 地雷数据
    private JButton[][] buttons; // 按钮数字
    private JButton startJB; // 开始按钮
    private JLabel l;
    private int row; // 行
    private int col; // 列
    private int mineNumber; // 地雷数
    private int mineCount; // 被找出的地雷数
    private boolean isOver; // 游戏是否结束

    public Mine() {
        row = 15;
        col = 15;
        mainFrame = new JFrame("扫雷v1.0");
        data = new int[row][col];
        buttons = new JButton[row][col];
        startJB = new JButton("start");
        l = new JLabel("welcome to mine!");
        mineNumber = row * col / 7;
    }

    /**
     * @Description 数据初始化
     */
    public void init() {
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        north.setLayout(new FlowLayout());
        center.setLayout(new FlowLayout());
        south.setLayout(new GridLayout(row, col, 4, 4));
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(north, BorderLayout.NORTH);
        mainFrame.add(center, BorderLayout.CENTER);
        mainFrame.add(south, BorderLayout.SOUTH);
        north.add(l);
        startJB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 重新开始/开始
                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++) {
                        buttons[i][j].setText(" ");
                        buttons[i][j].setBackground(Color.WHITE);
                        ;
                        data[i][j] = 0;
                        isOver = false;
                    }
                }
                hashMine();
                mineCount = 0;
                l.setText("let's go!");
            }
        });
        center.add(startJB);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setName(i + ":" + j);
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].addMouseListener(this);
                south.add(buttons[i][j]);
            }
        }
        hashMine();
    }

    public void start() {
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    /**
     * @Description 随机布雷
     */
    public void hashMine() {
        // 设置雷
        for(int i = 0; i < mineNumber; i++) {
            int r = (int) (Math.random() * row);
            int w = (int) (Math.random() * col);
            // if(data[r][w] == -1) {
            // i--;
            // continue;
            // }
            data[r][w] = -1;
        }
        // 计算周边雷的个数
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(data[i][j] == -1) {
                    continue;
                }
                int sum = 0;
                for(int m = -1; m <= 1; m++) {
                    for(int n = -1; n <= 1; n++) {
                        if(i + m >= 0 && i + m < row && j + n >= 0
                                && j + n < col && data[i + m][j + n] == -1) {
                            sum++;
                        }
                    }
                }
                data[i][j] = sum;
            }
        }
    }

    /**
     * @Description 游戏结束处理
     * @param over
     *            是否碰到雷
     */
    private void gameOver(boolean over) {
        if(over) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(data[i][j] == -1) {
                        buttons[i][j].setText("M");
                        buttons[i][j].setBackground(Color.RED);
                    }
                }
            }
            l.setText("-_-");
            isOver = true;
            return;
        }
        int sumPress = 0; // 统计被着色的按钮总数
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!buttons[i][j].getText().equals(" ")) {
                    sumPress++;
                }
            }
        }
        if(sumPress == row * col) {
            int sum = 0; // 统计被找到的雷数
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(data[i][j] == -1
                            && buttons[i][j].getText().equals("M")) {
                        sum++;
                    }
                }
            }
            if(sum >= mineNumber) {
                System.err.println(mineNumber);
                l.setText("^_^"); // 游戏胜利
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        try {
            if(isOver) { // 游戏结束
                return;
            }
            if(e.getButton() == MouseEvent.BUTTON3) { // 右击
                JButton jb = (JButton) e.getSource();
                if(jb.getText().equals("M")) {
                    jb.setText(" ");
                    mineCount--;
                    jb.setBackground(Color.WHITE);
                } else {
                    if(mineCount < mineNumber) { // 标记没有用完
                        jb.setText("M");
                        jb.setBackground(Color.BLUE);
                        mineCount++;
                    } else { // 标记用完
                        l.setText("the mine flag is over!");
                    }
                }
            } else {
                JButton jb = (JButton) e.getSource();
                mousePress(jb); // 处理左键单击事件
                gameOver(false); // 判断是否胜利
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void mousePress(JButton jb) {
        String str[] = jb.getName().split(":");
        int i = Integer.parseInt(str[0]);
        int j = Integer.parseInt(str[1]);
        if(data[i][j] == -1) { // 点到雷
            gameOver(true);
            return;
        } else {
            jb.setText(data[i][j] + "");
            jb.setBackground(Color.YELLOW);
            // 周边没雷时展开所有周边没雷的点
            if(data[i][j] == 0) {
                for(int m = -1; m <= 1; m++) {
                    for(int n = -1; n <= 1; n++) {
                        if(i + m >= 0
                                && j + n >= 0
                                && i + m < row
                                && j + n < col
                                && buttons[i + m][j + n].getText().equals(
                                        " ")) {
                            mousePress(buttons[i + m][j + n]);
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Mine mine = new Mine();
        mine.init();
        mine.start();
    }
}
