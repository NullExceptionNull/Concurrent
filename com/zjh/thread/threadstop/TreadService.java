package com.zjh.thread.threadstop;

/**
 * @author: Scott
 * @Description:  为了终止线程任务 自定义线程任务
 * @Date: Create in 20:38 2018/1/8
 */
public class TreadService {


    //执行线程
    private Thread excuteThread;


    private boolean flag = false;

    public void excute(Runnable task){

        excuteThread = new Thread(() -> {
                //守护线程
                Thread thread = new Thread(task);
                thread.setDaemon(true);
                thread.start();
            try {
                thread.join();
                flag = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        excuteThread.start();
    }

    public void shutDown(long mills){

        Long time = System.currentTimeMillis();

        //如果这个线程没有完成
        while (!flag){
            if (System.currentTimeMillis() - time >= mills ){
                System.out.println("任务超时，需要结束");

                //当前线程打断  不玩了
                excuteThread.interrupt();

                break;
            }
            //如果任务没有超时
            try {
                excuteThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断!");
                break;
            }
        }
        flag = false;
    }
}
