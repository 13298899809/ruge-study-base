package com.ruge.threadSafe;


/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 当多个线程共享同一个全局变量的时候，写的操作  可能出现数据冲突。
 * @date 2020/5/28 21:39
 * <p>
 * 现在有100张票  两个窗口同时抢票 使用多线程完成模拟
 */
public class Test001 extends Thread {
    public int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "---出售第" + (100 - ticket + 1) + "张票");
            ticket = ticket - 1;
        }
    }

    public static void main(String[] args) {
        Test001 test001 = new Test001();
        new Thread(test001, "张三").start();
        new Thread(test001, "李四").start();
    }
}
