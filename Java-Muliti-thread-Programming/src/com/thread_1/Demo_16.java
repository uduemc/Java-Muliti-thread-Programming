package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_16 {

    static class MyThread extends Thread {

        public void run() {
            super.run();
            try {
                for (int i = 0; i < 500000; i++) {
                    System.out.println("i=" + (i + 1));
                }
                System.out.println("run begin");
                Thread.sleep(200000);
                System.out.println("run end");
            } catch (Exception e) {
                System.out.println("先停止，在遇到 sleep 的时候再进入到 catch");
                e.printStackTrace();
            }
        }
        
        public static void main(String[] args) {
            MyThread mt = new MyThread();
            mt.start();
            mt.interrupt();
            System.out.println("end!");
        }
    }
}
