package com.zjh.thread.threadstop;

/**
 * @author: Scott
 * @Description: 正确的关闭一个线程
 * @Date: Create in 01:52 2018/1/8
 */
public class ThreadStop {

    private static class Worker extends Thread {

        private volatile boolean start = true;

        @Override
        public void run() {
            while (start){

            }
        }


        public void shutDown() {
            this.start = false;
        }
    }


    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        //主线程休眠5S

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        worker.shutDown();
    }
}
