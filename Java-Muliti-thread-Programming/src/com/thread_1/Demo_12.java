package com.thread_1;

/**
 * 判断线程是否停止状态 this.interrupted() 测试当前线程是否已经中断 this.isInterrupted() 测试线程是否已经中断
 *
 * @author uduemc
 */
public class Demo_12 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 500000; i++) {
                System.out.println("i=" + (i + 1));
            }
        }
    }

    public static void main(String[] args) {
        // 1
//        try {
//            MyThread mt = new MyThread();
//            mt.start();
//            Thread.sleep(1000);
//            mt.interrupt();
//            System.out.println("是否停止？1: " + mt.interrupted());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");
        
        // 2
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.interrupted());

        // 3
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println(thread.isInterrupted());
            System.out.println(thread.isInterrupted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
