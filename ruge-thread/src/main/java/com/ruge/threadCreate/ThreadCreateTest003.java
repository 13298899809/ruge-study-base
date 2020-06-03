package com.ruge.threadCreate;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 匿名内部类
 * @date 2020/5/27 23:04
 */
public class ThreadCreateTest003 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getClass().getName() + "--" + Thread.currentThread().getName() + "--" + i);
                }
            }
        }).start();
    }
}
