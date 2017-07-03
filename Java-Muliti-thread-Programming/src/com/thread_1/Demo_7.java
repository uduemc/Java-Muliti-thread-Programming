package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_7 {

    // Servlet 组件
    static class LoginServlet {

        private static String usernameRef;
        private static String passwordRed;

        synchronized public static void doPost(String username, String password) {
            try {
                usernameRef = username;
                passwordRed = password;
                if (username.equals("a")) {
                    Thread.sleep(5000);
                }
                System.out.println("username=" + usernameRef + " password=" + passwordRed);
            } catch (InterruptedException e) {
            }
        }
    }

    // 线程 A
    static class Alogin extends Thread {

        @Override
        public void run() {
            LoginServlet.doPost("a", "aa");
        }
    }

    // 线程 B
    static class Blogin extends Thread {

        @Override
        public void run() {
            LoginServlet.doPost("a", "aa");
        }
    }
    
    public static void main(String[] args) {
        Alogin a = new Alogin();
        a.start();
        Blogin b = new Blogin();
        b.start();
    }
}
