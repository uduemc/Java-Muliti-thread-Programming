package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用 stop 方法停止线程则是非常暴力的
 *
 * @author uduemc
 */
public class Demo_17 {

    static class MyThread extends Thread {

        private int i = 0;

        public void run() {
            try {
                while (true) {
                    i++;
                    System.out.println("i=" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Demo_17.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            MyThread mt = new MyThread();
            mt.start();
            Thread.sleep(8000);
            mt.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
