package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_1 {

    static class MyThread extends Thread {

        public void run() {
            System.out.println(this.getClass());
        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        System.out.println("end");
    }
}
