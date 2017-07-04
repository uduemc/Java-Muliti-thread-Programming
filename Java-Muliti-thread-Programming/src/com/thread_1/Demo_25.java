package com.thread_1;

/**
 * yield 方法，放弃当前的cpu资源。让给其他的任务去占用cpu执行。放弃的时间不确定，有可能刚刚放弃，马上又获得cpu的时间片
 *
 * @author uduemc
 */
public class Demo_25 {

    static class MyThread extends Thread {

        public void run() {
            long beginTime = System.currentTimeMillis();
            int count = 0;
            for (int i = 0; i < 50000000; i++) {
                Thread.yield();
                count = count + (i + 1);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("用时：" + (endTime - beginTime) + " 毫秒！");
        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
