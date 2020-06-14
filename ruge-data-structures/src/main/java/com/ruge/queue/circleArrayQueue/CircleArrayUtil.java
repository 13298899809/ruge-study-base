package com.ruge.queue.circleArrayQueue;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 循环数组工具类
 * @date 2020/6/13 16:59
 */
public class CircleArrayUtil {

    /**
     * @param circleArray {@link CircleArray}
     * @return 判断队列是否满
     */
    public static boolean isFull(CircleArray circleArray) {
        return (circleArray.getRear() + 1) % circleArray.getMaxSize() == circleArray.getFront();
    }

    /**
     * @param circleArray {@link CircleArray}
     * @return 判断队列是否为空
     */
    public static boolean isEmpty(CircleArray circleArray) {
        return circleArray.getRear() == circleArray.getFront();
    }

    /**
     * 添加数据到队列
     *
     * @param circleArray {@link CircleArray}
     * @param n           待添加的数据
     */
    public static void addQueue(CircleArray circleArray, int n) {
        // 判断队列是否满
        if (isFull(circleArray)) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        //直接将数据加入
        circleArray.getArr()[circleArray.getRear()] = n;
        //将 rear 后移, 这里必须考虑取模
        circleArray.setRear((circleArray.getRear() + 1) % circleArray.getMaxSize());
    }

    /**
     * @param circleArray {@link CircleArray}
     * @return 获取队列的数据, 出队列
     */
    public static int getQueue(CircleArray circleArray) {
        // 判断队列是否空
        if (isEmpty(circleArray)) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = circleArray.getArr()[circleArray.getFront()];
        circleArray.setFront((circleArray.getFront() + 1) % circleArray.getMaxSize());
        return value;

    }

    /**
     * 显示队列的所有数据
     *
     * @param circleArray {@link CircleArray}
     */
    public static void showQueue(CircleArray circleArray) {
        // 遍历
        if (isEmpty(circleArray)) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = circleArray.getFront(); i < circleArray.getFront() + size(circleArray); i++) {
            System.out.printf("arr[%d]=%d\n", i % circleArray.getMaxSize(), circleArray.getArr()[i % circleArray.getMaxSize()]);
        }
    }

    /**
     * @param circleArray {@link CircleArray}
     * @return 求出当前队列有效数据的个数
     */
    public static int size(CircleArray circleArray) {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (circleArray.getRear() + circleArray.getMaxSize() - circleArray.getFront()) % circleArray.getMaxSize();
    }

    /**
     * @param circleArray {@link CircleArray}
     * @return 显示队列的头数据， 注意不是取出数据
     */
    public static int headQueue(CircleArray circleArray) {
        // 判断
        if (isEmpty(circleArray)) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return circleArray.getArr()[circleArray.getFront()];
    }
}
