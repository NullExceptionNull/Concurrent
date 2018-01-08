package com.zjh.thread.threadstop.syntest;

/**
 * @author: Scott
 * @Description:
 * @Date: Create in 00:23 2018/1/9
 */
public class SynchronizedTest {

    private final static  Object lock = new Object();

    public static void main(String[] args) {
        Runnable runnable = ()->{

            synchronized (lock){
                try {
                    Thread.sleep(500_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");

        Thread t3 = new Thread(runnable,"t3");


        t1.start();

        t2.start();

        t3.start();
    }



    /**    jstack
     * "t3" #13 prio=5 os_prio=31 tid=0x00007f858d834800 nid=0x5803 waiting for monitor entry [0x0000700002d37000]
     java.lang.Thread.State: BLOCKED (on object monitor)
     at com.zjh.thread.threadstop.syntest.SynchronizedTest.lambda$main$0(SynchronizedTest.java:17)
     - waiting to lock <0x000000076ada4b60> (a java.lang.Object)
     at com.zjh.thread.threadstop.syntest.SynchronizedTest$$Lambda$1/931919113.run(Unknown Source)
     at java.lang.Thread.run(Thread.java:748)

     "t2" #12 prio=5 os_prio=31 tid=0x00007f858d833800 nid=0xa703 waiting for monitor entry [0x0000700002c34000]
     java.lang.Thread.State: BLOCKED (on object monitor)
     at com.zjh.thread.threadstop.syntest.SynchronizedTest.lambda$main$0(SynchronizedTest.java:17)
     - waiting to lock <0x000000076ada4b60> (a java.lang.Object)
     at com.zjh.thread.threadstop.syntest.SynchronizedTest$$Lambda$1/931919113.run(Unknown Source)
     at java.lang.Thread.run(Thread.java:748)

     "t1" #11 prio=5 os_prio=31 tid=0x00007f858e837800 nid=0x5603 waiting on condition [0x0000700002b31000]
     java.lang.Thread.State: TIMED_WAITING (sleeping)
     at java.lang.Thread.sleep(Native Method)
     at com.zjh.thread.threadstop.syntest.SynchronizedTest.lambda$main$0(SynchronizedTest.java:17)
     - locked <0x000000076ada4b60> (a java.lang.Object)
     at com.zjh.thread.threadstop.syntest.SynchronizedTest$$Lambda$1/931919113.run(Unknown Source)
     at java.lang.Thread.run(Thread.java:748)
     */


    /**
     Code:
     0: invokedynamic #2,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
     5: astore_1
     6: new           #3                  // class java/lang/Thread
     9: dup
     10: aload_1
     11: ldc           #4                  // String t1
     13: invokespecial #5                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
     16: astore_2
     17: new           #3                  // class java/lang/Thread
     20: dup
     21: aload_1
     22: ldc           #6                  // String t2
     24: invokespecial #5                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
     27: astore_3
     28: new           #3                  // class java/lang/Thread
     31: dup
     32: aload_1
     33: ldc           #7                  // String t3
     35: invokespecial #5                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
     38: astore        4
     40: aload_2
     41: invokevirtual #8                  // Method java/lang/Thread.start:()V
     44: aload_3
     45: invokevirtual #8                  // Method java/lang/Thread.start:()V
     48: aload         4
     50: invokevirtual #8                  // Method java/lang/Thread.start:()V
     53: return

     */
}
