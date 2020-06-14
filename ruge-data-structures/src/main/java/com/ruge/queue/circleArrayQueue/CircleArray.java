package com.ruge.queue.circleArrayQueue;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 循环数组
 * @date 2020/6/13 16:58
 */
@Data
public class CircleArray {
    /*表示数组的最大容量*/
    private int maxSize;
    /*front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素*/
    private int front = 0;
    /*rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.*/
    private int rear = 0;
    /*该数据用于存放数据, 模拟队列*/
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
}
