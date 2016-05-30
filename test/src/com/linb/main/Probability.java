package com.linb.main;

import java.util.Random;

public class Probability {
    public static void main(String[] args) {
        getAvgCount(100, 10000);
    }

    public static void getAvgCount(int num, int total) {
        Random r = new Random();
        int sum = 0;
        int maxNum = 100000;
        for (int i = 0; i < maxNum; i++) {
            int count = 0;
            while(true) {
                int res = r.nextInt(total);
                count++;
                if (res < num) {
                    // System.out.println(count);
                    break;
                }
            }
            sum += count;
        }
        System.out.println("总次数：" + sum );
        System.out.println("平均次数：" + 1.0 * sum / maxNum);
    }
}
