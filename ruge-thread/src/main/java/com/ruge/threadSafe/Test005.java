package com.ruge.threadSafe;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 一个线程使用同步函数，另一个线程使用静态同步代码块，能同步吗？  no
 * @date 2020/5/29 22:27
 */
public class Test005 extends Thread {
    public static int ticket = 100;
    /*静态同步方法
     * 等于同步锁中的Test005.class
     * */
    // private Object object = new Object();
    private Object object = Test005.class;
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

    public static synchronized void sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---静态同步方法--出售第" + (100 - ticket + 1) + "张票");
            ticket = ticket - 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test005 test004 = new Test005();
        new Thread(test004, "张三").start();
        Thread.sleep(20);
        test004.flag = false;
        new Thread(test004, "李四").start();
    }
}