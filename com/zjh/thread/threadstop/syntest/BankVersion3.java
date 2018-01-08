package com.zjh.thread.threadstop.syntest;

/**
 * @author: Scott
 * @Description:
 * @Date: Create in 00:50 2018/1/9
 */
public class BankVersion3 {

    public static void main(String[] args) {
        final SynchRunnable runnable = new SynchRunnable();


        Thread t1 = new Thread(runnable,"t1");


        Thread t2 = new Thread(runnable,"t2");


        Thread t3 = new Thread(runnable,"t3");


        t1.start();

        t2.start();

        t3.start();


    }
}
