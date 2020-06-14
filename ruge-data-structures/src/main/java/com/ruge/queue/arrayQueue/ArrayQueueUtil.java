package com.ruge.queue.arrayQueue;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 数组队列常用方法
 * @date 2020/6/13 16:24
 */
public class ArrayQueueUtil {
    /**
     * 判断队列是否满
     *
     * @param arrayQueue {@link ArrayQueue}
     * @return {@link boolean}
     */
    public static boolean isFull(ArrayQueue arrayQueue) {
        return arrayQueue.getRear() == arrayQueue.getMaxSize() - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @param arrayQueue {@link ArrayQueue}
     * @return {@link boolean}
     */
    public static boolean isEmpty(ArrayQueue arrayQueue) {
        return arrayQueue.getRear() == arrayQueue.getFront();
    }


    /**
     * 添加数据到队列
     *
     * @param arrayQueue {@link ArrayQueue}
     * @param n          添加的数据
     */
    public static void addQueue(ArrayQueue arrayQueue, int n) {
        // 判断队列是否满
        if (isFull(arrayQueue)) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        // 让rear 后移
        arrayQueue.setRear(arrayQueue.getRear()+1);
        arrayQueue.getArr()[arrayQueue.getRear()] = n;
    }

    /**
     * 获取队列的数据, 出队列
     *
     * @param arrayQueue {@link ArrayQueue}
     * @return 队列中的数据
     */
    public static int getQueue(ArrayQueue arrayQueue) {
        // 判断队列是否空
        if (isEmpty(arrayQueue)) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // front后移
        arrayQueue.setFront(arrayQueue.getFront() + 1);
        return arrayQueue.getArr()[arrayQueue.getFront()];
    }

    /**
     * 显示队列的所有数据
     *
     * @param arrayQueue {@link ArrayQueue}
     */
    public static void showQueue(ArrayQueue arrayQueue) {
        // 遍历
        if (isEmpty(arrayQueue)) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arrayQueue.getArr().length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arrayQueue.getArr()[i]);
        }
    }

    /**
     * 显示队列的头数据， 注意不是取出数据
     *
     * @param arrayQueue {@link ArrayQueue }
     * @return 队列头部数据
     */
    public static int headQueue(ArrayQueue arrayQueue) {
        // 判断
        if (isEmpty(arrayQueue)) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arrayQueue.getArr()[arrayQueue.getFront() + 1];
    }
}
