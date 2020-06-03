package com.ruge.threadVolatile;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/5/30 21:35
 */
public class VolatileNoAtomicWithStatic extends Thread {
    /*static修饰的变量会存放再静态区域里面 所有线程会共享该数据*/
    private static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + "-->" + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            VolatileNoAtomicWithStatic atomic = new VolatileNoAtomicWithStatic();
            atomic.start();
        }
    }
}
