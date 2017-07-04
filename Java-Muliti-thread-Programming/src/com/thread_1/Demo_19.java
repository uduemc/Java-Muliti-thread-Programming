package com.thread_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用 stop() 释放锁将会给数据造成不一致性的结果。如果出现这样的情况，程序处理的数据将会有可能遭到破坏
 *
 * @author uduemc
 */
public class Demo_19 {

    static class SynchronizedObject {

        private String username = "a";
        private String password = "aa";

        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @param username the username to set
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * @return the password
         */
        public String getPassword() {
            return password;
        }

        /**
         * @param password the password to set
         */
        public void setPassword(String password) {
            this.password = password;
        }

        synchronized public void printString(String username, String password) {
            try {
                this.setUsername(username);
                Thread.sleep(100000);
                this.setPassword(password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {

        private SynchronizedObject object;

        public MyThread(SynchronizedObject object) {
            super();
            this.object = object;
        }

        public void run() {
            this.object.printString("b", "bb");
        }
    }

    public static void main(String[] args) {

        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread thread = new MyThread(object);
            thread.start();
            Thread.sleep(500);
            thread.stop();
            System.out.println(object.getUsername() + "|" + object.getPassword());
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_19.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
