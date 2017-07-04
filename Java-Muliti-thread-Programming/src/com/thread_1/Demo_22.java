package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用 suspend 与 resume 方法时，如果使用不当，极易造成公共同步对象的独占，使其他线程无法访问公共的同步对象
 *
 * @author uduemc
 */
public class Demo_22 {

    static class SynchronizedObject {

        synchronized public void printString() {
            System.out.println("begin");
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("a 线程用户 suspend 了！");
                Thread.currentThread().suspend();
            }
            System.out.println("end");
        }
    }

    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 启动了，但是进入不了 printString() 方法");
                    System.out.println("因为 printString() 方法被a线程锁定并且永远 suspend 暂停了!");
                    object.printString();
                }
            };

            thread2.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_22.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
