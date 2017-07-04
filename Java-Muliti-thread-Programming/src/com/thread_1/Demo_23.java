package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 关于 suspend 与 resume 另外一个情况
 *
 * @author uduemc
 */
public class Demo_23 {

    static class MyThread extends Thread {

        private long i = 0;

        @Override
        public void run() {
            while (true) {
                this.i++;
                System.out.println("i=" + this.i);
            }
        }
    }

    public static void main(String[] args) {
        try {
            MyThread mt = new MyThread();
            mt.start();
            Thread.sleep(1000);
            mt.suspend();
            System.out.println("main end!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_23.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
