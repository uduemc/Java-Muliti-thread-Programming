package com.thread_1;

import java.util.Random;

/**
 * 线程的优先级 线程一共分成 1~10 等级。超出或小于报 IllegalArgumentException 异常 线程优先级的继承特性
 * A线程启动B线程，B线程的优先级与A线程是一样的
 *
 * @author uduemc
 */
public class Demo_26 {

    static class MyThread1 extends Thread {

        @Override
        public void run() {
            long beginTime = System.currentTimeMillis();
            long addResult = 0;
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 50000; i++) {
                    Random random = new Random();
                    random.nextInt();
                    addResult = addResult + i;
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("★ ★ ★ ★ ★ thread 1 user time=" + (endTime - beginTime));
        }
    }

    static class MyThread2 extends Thread {

        @Override
        public void run() {
            long beginTime = System.currentTimeMillis();
            long addResult = 0;
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 50000; i++) {
                    Random random = new Random();
                    random.nextInt();
                    addResult = addResult + i;
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("☆ ☆ ☆ ☆ ☆ thread 2 user time=" + (endTime - beginTime));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(1);
            thread1.start();
            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(10);
            thread2.start();
        }
    }
}
