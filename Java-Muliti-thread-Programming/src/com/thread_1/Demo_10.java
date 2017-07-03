package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_10 {

    static class CountOperate extends Thread {

        public CountOperate() {
            System.out.println("CountOperate--begin");
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("CountOperate--end");
        }

        @Override
        public void run() {
            System.out.println("run--begin");
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("run--end");
        }
    }
    
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread th = new Thread(c);
        th.setName("A");
        th.start();
    }
}
