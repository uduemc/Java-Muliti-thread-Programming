package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用优先级对比运行次数
 *
 * @author uduemc
 */
public class Demo_27 {

    static class MyThread1 extends Thread {

        private int count = 0;

        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    return;
                }
                this.count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    static class MyThread2 extends Thread {

        private int count = 0;

        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    return;
                }
                this.count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        thread1.setPriority(Thread.NORM_PRIORITY - 3);
        thread2.setPriority(Thread.NORM_PRIORITY + 3);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_27.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread1.stop();
        thread2.stop();
        System.out.println("thread1=" + thread1.getCount());
        System.out.println("thread2=" + thread2.getCount());
    }
}
