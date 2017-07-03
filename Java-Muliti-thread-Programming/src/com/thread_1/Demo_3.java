package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_3 {

    static class MyThread extends Thread {

        int i;

        public MyThread(int i) {
            super();
            this.i = i;
        }

        public void run() {
            System.out.println("i: " + this.i);
        }
    }

    public static void main(String[] args) {
        MyThread mt1 = new MyThread(1);
        MyThread mt2 = new MyThread(2);
        MyThread mt3 = new MyThread(3);
        MyThread mt4 = new MyThread(4);
        MyThread mt5 = new MyThread(5);
        MyThread mt6 = new MyThread(6);
        MyThread mt7 = new MyThread(7);
        MyThread mt8 = new MyThread(8);
        MyThread mt9 = new MyThread(9);
        MyThread mt10 = new MyThread(10);
        MyThread mt11 = new MyThread(11);
        MyThread mt12 = new MyThread(12);
        MyThread mt13 = new MyThread(13);
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();
        mt6.start();
        mt7.start();
        mt8.start();
        mt9.start();
        mt10.start();
        mt11.start();
        mt12.start();
        mt13.start();
    }
}
