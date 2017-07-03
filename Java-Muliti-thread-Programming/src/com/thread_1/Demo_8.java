package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_8 {

    static class MyThread extends Thread {

        int i = 5;

        @Override
        synchronized public void run() {
            super.run();
            i--;
            System.out.println("i: " + i + " run: " + Thread.currentThread().getName());
        }
    }
    
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread th1 = new Thread(mt);
        Thread th2 = new Thread(mt);
        Thread th3 = new Thread(mt);
        Thread th4 = new Thread(mt);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
