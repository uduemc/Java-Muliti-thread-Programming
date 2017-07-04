package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用 return 停止线程 使用 interrupt() 与 return 结合使用也能实现停止线程的效果
 * 建议使用抛出异常的方式中断线程
 * @author uduemc
 */
public class Demo_20 {

    static class MyThread extends Thread {

        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    System.out.println("停止了！");
                    return ;
                }
                System.out.println("timer="+System.currentTimeMillis());
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_20.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
