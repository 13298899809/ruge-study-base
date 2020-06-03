package com.ruge.threadCreate;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 线程的创建
 * @date 2020/5/27 22:42
 */
public class Test001 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--继承Thread的多线程-->" + i);
        }
    }
}
