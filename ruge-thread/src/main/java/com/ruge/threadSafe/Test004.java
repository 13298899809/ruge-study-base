package com.ruge.threadSafe;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 同步代码块和同步方法  能同步数据吗？
 * @date 2020/5/29 22:27
 */
public class Test004 extends Thread {
    public int ticket = 100;
    /*同步代码块和同步方法交替执行
     * 一个线程使用同步代码块 另一个线程使用同步方法，交替执行
     * 结论: 当同步代码块的锁是this锁的时候 可以同步
     *      因为同步方法的锁 就是this锁
     *      当同步代码库的锁是对象锁的时候  不能同步
     * */
    // private Object object = new Object();
    private Object object = this;
    public boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (ticket > 0) {
                sale();
            }
        } else {
            while (ticket > 0) {
                synchronized (object) {
                    if (ticket > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "---同步代码块--出售第" + (100 - ticket + 1) + "张票");
                        ticket = ticket - 1;
                    }
                }
            }
        }
    }

    public synchronized void sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---同步方法--出售第" + (100 - ticket + 1) + "张票");
            ticket = ticket - 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test004 test004 = new Test004();
        new Thread(test004, "张三").start();
        Thread.sleep(20);
        test004.flag = false;
        new Thread(test004, "李四").start();
    }
}