package com.ruge.threadStop;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 多线程终止
 * @date 2020/6/3 20:53
 */
public class ThreadStop001 extends Thread {
    public volatile boolean run = true;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("线程开始");
        while (run) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("线程运行ing" + LocalDateTime.now());
        }
        System.out.println("线程结束");
    }

    public void threadStop() {
        run = false;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStop001 threadStop001 = new ThreadStop001();
        new Thread(threadStop001).start();
        TimeUnit.SECONDS.sleep(5);
        threadStop001.threadStop();
    }
}
