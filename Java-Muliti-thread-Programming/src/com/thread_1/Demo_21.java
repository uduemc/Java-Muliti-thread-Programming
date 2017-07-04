package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 暂停线程 暂停线程意味着此线程可以恢复运行， 使用 suspend() 暂停线程 使用 resume() 恢复线程
 *
 * @author uduemc
 */
public class Demo_21 {

    static class MyThread extends Thread {

        private long i = 0;

        /**
         * @return the i
         */
        public long getI() {
            return i;
        }

        /**
         * @param i the i to set
         */
        public void setI(long i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    System.out.println("退出！");
                    return;
                }
                this.i++;
            }
        }
    }

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        try {
            thread.start();
            Thread.sleep(5000);
            // A
            thread.suspend();
            System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(5000);
            System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());
            // B
            thread.resume();
            Thread.sleep(5000);
            // C
            thread.suspend();
            System.out.println("B=" + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(5000);
            System.out.println("B=" + System.currentTimeMillis() + " i=" + thread.getI());
            thread.resume();
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_21.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // 终止
            System.out.println("interrupt");
            thread.interrupt();
        }
        System.out.println("end");
        return;
    }
}
