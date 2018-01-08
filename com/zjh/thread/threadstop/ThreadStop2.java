package com.zjh.thread.threadstop;

/**
 * @author: Scott
 * @Description: 通过打断的方式结束线程
 * @Date: Create in 02:01 2018/1/8
 */
public class ThreadStop2 {


    private static class Worker2 extends Thread {


        @Override
        public void run() {
            while (true) {
                //注意 此处必须判断县城状态 不然不会捕捉
                if (Thread.interrupted()) {
                    System.out.println("检测到被中断");
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {
        Worker2 worker = new Worker2();

        worker.start();

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始中断");
        worker.interrupt();
    }


}
