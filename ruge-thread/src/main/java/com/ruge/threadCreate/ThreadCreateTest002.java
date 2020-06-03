package com.ruge.threadCreate;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/5/27 23:01
 */
public class ThreadCreateTest002 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "开始");
        /*创建线程*/
        Test002 test002 = new Test002();
        /*启动线程*/
        new Thread(test002).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程-->" + i);
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}
