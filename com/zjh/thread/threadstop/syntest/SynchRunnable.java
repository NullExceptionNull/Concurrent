package com.zjh.thread.threadstop.syntest;

/**
 * @author: Scott
 * @Description:
 * @Date: Create in 00:46 2018/1/9
 */
public class SynchRunnable implements Runnable {

    private int index = 1;


    private final static int MAX = 500;


    private final Object LOCK = new Object();


//    @Override
//    public  void run() {
//
//        while (true) {
//            synchronized (LOCK) {
//                if (index > MAX) {
//                    break;
//                }
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + ":的号码是 ："+ index ++ );
//
//            }
//        }
//    }


    /**
     * 这种锁是  this  对象锁
     */
    @Override
    public  synchronized  void run() {

        while (true) {

                if (index > MAX) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":的号码是 ："+ index ++ );


        }
    }
}
