package com.zjh.thread.threadstop;


/**
 * @author: Scott
 * @Description:
 * @Date: Create in 21:16 2018/1/8
 */
public class ThreadForce2 {
    public static void main(String[] args) {
        TreadService service = new TreadService();
        long start = System.currentTimeMillis();
        service.excute(() -> {
            //load a very heavy resource.
            /*while (true) {

            }*/
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutDown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
