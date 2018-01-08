package com.zjh.thread.threadstop;

/**
 * @author: Scott
 * @Description:  此处一第一个 demo 不同  当 JOB1 任务时间过长 所以worker线程就没有机会取检测到信号
 * @Date: Create in 02:12 2018/1/8
 */
public class ThreadStopForce {
    private static class Worker extends Thread {

        private volatile boolean start = true;

        @Override
        public void run() {
            while (start){
                //DOING  JOB1
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
