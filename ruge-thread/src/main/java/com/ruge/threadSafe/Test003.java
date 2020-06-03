package com.ruge.threadSafe;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 同步方法解决线程安全
 * @date 2020/5/29 22:27
 */
public class Test003 extends Thread {
    public int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            sale();
        }
    }

    public synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "---出售第" + (100 - ticket + 1) + "张票");
            ticket = ticket - 1;
        }
    }

    public static void main(String[] args) {
        Test003 test003 = new Test003();
        new Thread(test003, "张三").start();
        new Thread(test003, "李四").start();
    }
}