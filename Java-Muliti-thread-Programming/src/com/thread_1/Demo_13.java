package com.thread_1;

/**
 * 让运行的线程判断是否停止状态，如果是停止状态则后面的代码不再运行
 *
 * @author uduemc
 */
public class Demo_13 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("已经停止了状态，退出！");
                    break;
                }
                System.out.println("i=" + (i + 1));
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            MyThread mt = new MyThread();
            mt.start();
            Thread.sleep(1000);
            mt.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
