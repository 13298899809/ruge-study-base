package com.ruge.threadVolatile;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 内存可见性 demo
 * @date 2020/5/30 20:39
 */
@Data
public class VolatileDeme extends Thread {
    public volatile int flag = 0;

    @Override
    public void run() {
        while (flag == 0) {

        }
        System.out.println("server start " + LocalDateTime.now());
        while (flag == 1) {

        }
        System.out.println("server end " + LocalDateTime.now());
    }

    public void startThread() {
        this.flag = 1;
    }

    public void stopThread() {
        this.flag = 2;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDeme deme = new VolatileDeme();
        deme.start();
        System.out.println("temp1-->" + deme.getFlag());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("temp2-->" + deme.getFlag());
        deme.startThread();
        System.out.println("temp3-->" + deme.getFlag());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("temp4-->" + deme.getFlag());
        deme.stopThread();
        System.out.println("temp5-->" + deme.getFlag());
    }
}
