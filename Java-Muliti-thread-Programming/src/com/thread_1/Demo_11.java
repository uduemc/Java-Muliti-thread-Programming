package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * isAlive 判断当前的线程是否处于激活的状态
 *
 * @author uduemc
 */
public class Demo_11 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("run -- isAlive: " + this.isAlive());
        }
    }

    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        System.out.println("main -- begin mythread: " + mythread.isAlive());
        mythread.start();
        System.out.println("main --  mythread: " + mythread.isAlive());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_11.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("main -- end mythread: " + mythread.isAlive());
    }
}
