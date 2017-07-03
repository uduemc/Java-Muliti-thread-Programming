package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_14 {

    static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
//            for (int i = 0; i < 500000; i++) {
//                if (this.interrupted()) {
//                    System.out.println("已经是停止状态，退出！");
//                    break;
//                }
//                System.out.println("i=" + (i + 1));
//            }
//            System.out.println("for 下面，测试是否终止运行 run() 里面的代码");

            try {
                for (int i = 0; i < 500000; i++) {
                    if (this.interrupted()) {
                        System.out.println("已经是停止状态，退出！");
                        throw new InterruptedException();
                    }
                    System.out.println("i=" + (i + 1));
                }
                System.out.println("for 下面，测试是否终止运行 run() 里面的代码");
            } catch (InterruptedException e) {
                System.out.println("进入 MyThread.java 中 run 方法下的 catch 异常");
                e.printStackTrace();
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
