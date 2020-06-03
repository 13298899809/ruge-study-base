package com.ruge.threadDeadlock;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 多线程死锁
 * @date 2020/5/30 8:36
 * t1先运行，这个时候flag==true,先锁定obj1,然后睡眠1秒钟
 * 而t1在睡眠的时候，另一个线程t2启动，flag==false,先锁定obj2,然后也睡眠1秒钟
 * t1睡眠结束后需要锁定obj2才能继续执行，而此时obj2已被t2锁定
 * t2睡眠结束后需要锁定obj1才能继续执行，而此时obj1已被t1锁定
 * t1、t2相互等待，都需要得到对方锁定的资源才能继续执行，从而死锁。
 *
 * 从这个例子也可以反映出，死锁是因为多线程访问共享资源，由于访问的顺序不当所造成的，通常是一个线程锁定了一个资源A，而又想去锁定资源B；
 * 在另一个线程中，锁定了资源B，而又想去锁定资源A以完成自身的操作，两个线程都想得到对方的资源，而不愿释放自己的资源，造成两个线程都在等待，而无法执行的情况
 */
public class DeadLock extends Thread {
    public static int ticket = 100;
    private boolean flag;
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() + "已经锁住obj1");

                while (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        if (ticket > 0) {
                            System.out.println(Thread.currentThread().getName() + "---出售第" + (100 - ticket + 1) + "张票");
                            ticket = ticket - 1;
                        }
                    }
                }
            }
        } else {
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + "已经锁住obj2");

                while (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1) {
                        if (ticket > 0) {
                            System.out.println(Thread.currentThread().getName() + "---出售第" + (100 - ticket + 1) + "张票");
                            ticket = ticket - 1;
                        }
                    }
                }
            }
        }
    }
}
