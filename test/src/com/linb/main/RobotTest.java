package com.linb.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * @ClassName Robot
 * @Description robot类测试
 * @author linb
 * @date 2016年2月16日 下午3:28:41
 */
public class RobotTest {

    public static Integer[] pos = { 140, 300, 460, 620 };

    public static void main(String[] args) throws AWTException {
        playDaDouDou();
    }
    
    /**
     * @Description 打豆豆游戏
     * @throws AWTException
     */
    public static void playDaDouDou() throws AWTException {
        Robot robot = new Robot();
        int num = 0;
        while(num < 400) {
            for(int i = 0; i < pos.length; i++) {
                Color color = robot.getPixelColor(pos[i], 485);
                // System.out.println("第" + i + "个坐标颜色：" + color.getRGB());
                if(color.getRGB() < -3000000) {
                    robot.mouseMove(pos[i], 485);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                }
            }
            num++;
        }
    }
}
