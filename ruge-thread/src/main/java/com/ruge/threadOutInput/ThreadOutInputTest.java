package com.ruge.threadOutInput;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 多线程 生产者和消费者测试
 * @date 2020/5/31 21:49
 */
public class ThreadOutInputTest {

    public static void main(String[] args) {
        Res res = new Res();
        new ThreadOut(res).start();
        new ThreadInput(res).start();
    }
}
