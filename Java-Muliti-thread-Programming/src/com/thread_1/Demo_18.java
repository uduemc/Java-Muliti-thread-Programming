package com.thread_1;

/**
 * stop() 方法会抛出 java.lang.ThreadDeath 异常，此异常不需要显示的捕获
 *
 * @author uduemc
 */
public class Demo_18 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                this.stop();
            } catch (ThreadDeath e) {
                System.out.println("捕获到了 ThreadDeath 异常");
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
