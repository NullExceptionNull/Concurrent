package com.zjh.thread.threadstop.syntest;

import com.sun.corba.se.spi.activation._LocatorImplBase;

/**
 * @author: Scott
 * @Description:
 * @Date: Create in 01:14 2018/1/9
 */
public class SynThis {

    public static void main(String[] args) {

        ThisLock thisLock = new ThisLock();
        new Thread("t1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();


        new Thread("t2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
    }

    static class ThisLock{

        private final Object lock = new Object();

        public synchronized void m1(){
            try {
                System.out.println(Thread.currentThread().getName()+"占用");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public  void m2(){

            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread().getName()+"占用");
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
