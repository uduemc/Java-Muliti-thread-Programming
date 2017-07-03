package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_2 {

    static class MyThread extends Thread {

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    int time = (int) (Math.random() * 1000);
                    Thread.sleep(time);
                    System.out.println("run: " + Thread.currentThread().getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            MyThread th = new MyThread();
            th.setName("myThread");
            th.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run: " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
