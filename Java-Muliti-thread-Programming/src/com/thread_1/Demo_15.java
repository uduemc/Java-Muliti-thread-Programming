package com.thread_1;

/**
 * 在沉睡中停止
 * @author uduemc
 */
public class Demo_15 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                System.out.println("run begin!");
                Thread.sleep(20000);
                System.out.println("run end!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            MyThread mt = new MyThread();
            mt.start();
            Thread.sleep(200);
            mt.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
