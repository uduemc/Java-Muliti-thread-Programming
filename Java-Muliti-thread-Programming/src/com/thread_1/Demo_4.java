package com.thread_1;

/**
 *
 * @author uduemc
 */
public class Demo_4 {
    static class MyThread extends Thread{
        int count = 5;
        public MyThread(String name){
            super();
            this.setName(name);
        }
        
        public void run(){
            super.run();
            while(this.count > 0){
                System.out.println("由 "+Thread.currentThread().getName()+" 计算，count="+this.count--);
            }
        }
    }
    
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("A");
        MyThread mt2 = new MyThread("B");
        MyThread mt3 = new MyThread("C");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
