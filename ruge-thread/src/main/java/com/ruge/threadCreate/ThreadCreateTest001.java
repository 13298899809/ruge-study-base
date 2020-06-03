package com.ruge.threadCreate;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 多线程创建的测试
 * @date 2020/5/27 22:43
 */
public class ThreadCreateTest001 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "开始");
        /*创建线程*/
        Test001 test001 = new Test001();
        /*启动线程*/
        test001.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程-->" + i);
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}
