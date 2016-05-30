package com.linb.main;

public class Test2 {
    public static void main(String[] args) {
        ThreadTest thread1 = new ThreadTest("thread1");
        ThreadTest thread2 = new ThreadTest("thread2");
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
    }

    public static class ThreadTest implements Runnable {

        private static Integer num = 0;
        private static Integer maxNum = 100;
        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }

        public void run() {
            while(true) {
                if(num > maxNum) {
                    return;
                }
                System.out.println(name + " : " + num);
                num++;
            }
        }
    }
}
