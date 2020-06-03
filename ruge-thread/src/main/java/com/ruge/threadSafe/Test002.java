package com.ruge.threadSafe;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 同步代码块解决线程安全
 * @date 2020/5/29 22:27
 */
public class Test002 extends Thread {
    private Object object = new Object();
    public int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            /*同步代码库解决线程安全问题*/
            synchronized (object) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "---出售第" + (100 - ticket + 1) + "张票");
                    ticket = ticket - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test002 test002 = new Test002();
        new Thread(test002, "张三").start();
        new Thread(test002, "李四").start();
    }
}