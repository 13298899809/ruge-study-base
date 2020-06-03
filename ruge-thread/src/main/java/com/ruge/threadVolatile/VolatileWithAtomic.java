package com.ruge.threadVolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/5/30 21:42
 */
public class VolatileWithAtomic extends Thread {
    
    private static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count.getAndIncrement();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            VolatileWithAtomic atomic = new VolatileWithAtomic();
            atomic.start();
        }
    }
}
