package com.ruge.threadOutInput;


/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 线程消费端
 * @date 2020/5/31 21:46
 */
public class ThreadInput extends Thread {
    Res res;

    public ThreadInput(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                //不能用 if，因为可能有多个线程
                //进入到while语句内，说明 isEmpty==false，那么表示有数据了，不能生产，必须要等待消费者消费
                while (res.isEmpty()) {
                    try {
                        //导致当前线程等待，进入等待池中，只能被其他线程唤醒
                        res.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("消费端：" + res);
                res.setEmpty(true);//设置 isEmpty为true，表示需要生产者生产对象
                res.notifyAll();//消费完毕，唤醒所有生产者
            }
        }
    }
}
