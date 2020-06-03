package com.ruge.threadDeadlock;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 死锁测试
 * @date 2020/5/30 8:38
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true), "线程1");
        Thread t2 = new Thread(new DeadLock(false), "线程2");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
