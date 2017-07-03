package com.thread_1;

/**
 * currentThread 返回代码当前被线程调用的线程信息
 * @author uduemc
 */
public class Demo_9 {

    static class MyThread extends Thread {

        public MyThread() {
            System.out.println("构造方法打印：" + Thread.currentThread().getName());
        }

        @Override
        public void run() {
            System.out.println("run 方法打印：" + Thread.currentThread().getName());
        }
    }
    
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        mt.run();
    }
}
