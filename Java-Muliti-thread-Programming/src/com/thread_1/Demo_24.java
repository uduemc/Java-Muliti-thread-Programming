package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uduemc
 */
public class Demo_24 {

    static class MyObject {

        private String username = "1";
        private String password = "11";

        public void setValue(String u, String p) {
            this.username = u;
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("停止 a 线程!");
                Thread.currentThread().suspend();
            }
            this.password = p;
        }

        public void printUsernamePassword() {
            System.out.println(this.username + "|" + this.password);
        }
    }
    
    public static void main(String[] args) {
        try {
            final MyObject myobject = new MyObject();
            Thread thread1 = new Thread(){
                @Override
                public void run(){
                    myobject.setValue("a", "aa");
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(500);
            Thread thread2 = new Thread(){
                @Override
                public void run(){
                    myobject.printUsernamePassword();
                }
            };
            thread2.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_24.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
