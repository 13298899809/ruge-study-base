package com.ruge.threadVolatile;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/5/30 21:28
 */
@Data
public class VolatileNoAtomic extends Thread {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + "-->" + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            VolatileNoAtomic atomic = new VolatileNoAtomic();
            atomic.start();
        }
    }
}
