package com.ruge.threadOutInput;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 多线程生产者
 * @date 2020/5/31 21:48
 */
public class ThreadOut extends Thread {
    Res res;

    public ThreadOut(Res res) {
        this.res = res;
    }


    @Override
    public void run() {
        // 写的操作 0 1
        int count = 0;
        while (true) {
            synchronized (res) {
                //不能用 if，因为可能有多个线程
                //进入到while语句内，说明 isEmpty==false，那么表示有数据了，不能生产，必须要等待消费者消费
                while (!res.isEmpty()) {
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
                if ((count % 2) == 0) {
                    res.setId(count);
                    res.setUserName("张三");
                    res.setSex("女");
                } else {
                    res.setId(count);
                    res.setUserName("李四");
                    res.setSex("男");
                }
                count++;
                System.out.println("生产者-->" + res);
                if (count > 10) {
                    res.setEmpty(false);
                    //生产完毕，唤醒所有消费者
                    res.notifyAll();
                }
            }

        }

    }

}
