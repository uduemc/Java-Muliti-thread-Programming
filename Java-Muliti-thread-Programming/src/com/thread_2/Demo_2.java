package com.thread_2;

/**
 *
 * @author uduemc
 */
public class Demo_2 {
    
    // HasSelfPrivateNum
    static class HashSelfPrivateNum{
        private int num = 0;
        private void addI(String name){
            try {
                if(name.equals("a")){
                    num = 100;
                    System.out.println("a set over!");
                    Thread.sleep(2000);
                }else{
                    num = 200;
                    System.out.println("b set over!");
                }
                System.out.println(name+ " num " + num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    static class ThreadA extends Thread{
        private HashSelfPrivateNum numRef;
        public ThreadA(HashSelfPrivateNum numRef){
            super();
            this.numRef = numRef;
        }
        
        @Override
        public void run(){
            super.run();
            numRef.addI("a");
        }
    }
    
    static class ThreadB extends Thread{
        private HashSelfPrivateNum numRef;
        public ThreadB(HashSelfPrivateNum numRef){
            super();
            this.numRef = numRef;
        }
        
        @Override
        public void run(){
            super.run();
            numRef.addI("b");
        }
    }
    
    public static void main(String[] args) {
        HashSelfPrivateNum numRef = new HashSelfPrivateNum();
        ThreadA tha = new ThreadA(numRef);
        tha.start();
        ThreadB thb = new ThreadB(numRef);
        thb.start();
    }
}
