package com.ruge.threadBlock.join;

import java.util.concurrent.TimeUnit;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: join测试
 * @date 2020/5/27 23:27
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getClass().getName() + "--" + Thread.currentThread().getName() + "---" + i);
                }
            }
        });
        /*thread1 主线程 交替执行*/
        thread1.start();
        /*主线程等子线程执行完在执行 start*/
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*主线程等子线程执行完在执行 end*/
        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadJoinTest.class.getName() + "--" + Thread.currentThread().getName() + "---" + i);
        }
    }
}
