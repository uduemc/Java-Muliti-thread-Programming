package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_5 {

    static class MyThread implements Runnable {

        private int count = 5;

        @Override
        public void run() {
            while (this.count > 0) {
                System.out.println("run: " + Thread.currentThread().getName() + ", count: " + this.count--);
            }
        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread th1 = new Thread(mt, "A");
        Thread th2 = new Thread(mt, "B");
        Thread th3 = new Thread(mt, "C");
        Thread th4 = new Thread(mt, "D");
        Thread th5 = new Thread(mt, "E");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
    }
}
