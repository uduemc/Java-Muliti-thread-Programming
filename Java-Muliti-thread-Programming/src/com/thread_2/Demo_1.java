package com.thread_2;

/**
 *
 * @author uduemc
 */
public class Demo_1 {

    static class HasSelfPrivateNum {

        private int num = 0;

        synchronized public void addI(String username) {
            try {
                if (username.equals("a")) {
                    num = 100;
                    System.out.println("a set over!");
                    Thread.sleep(2000);
                } else {
                    num = 200;
                    System.out.println("b set over!");
                }
                System.out.println("num=" + this.num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread1 extends Thread {

        private HasSelfPrivateNum numRef;

        public MyThread1(HasSelfPrivateNum numRef) {
            super();
            this.numRef = numRef;
        }

        public void run() {
            super.run();
            numRef.addI("a");
        }
    }

    static class MyThread2 extends Thread {

        private HasSelfPrivateNum numRef;

        public MyThread2(HasSelfPrivateNum numRef) {
            super();
            this.numRef = numRef;
        }

        public void run() {
            super.run();
            numRef.addI("b");
        }
    }

    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        MyThread1 thread1 = new MyThread1(numRef);
        thread1.start();
        MyThread2 thread2 = new MyThread2(numRef);
        thread2.start();
    }
}
