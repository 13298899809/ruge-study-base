package com.ruge.queue.arrayQueue;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 数组队列
 * @date 2020/6/13 16:22
 */
@Data
public class ArrayQueue {
    /*表示数组的最大容量*/
    private int maxSize;
    /*队列头*/
    private int front;
    /*队列尾*/
    private int rear;
    /*该数据用于存放数据, 模拟队列*/
    private int[] arr;

    /**
     * 创建队列的构造器
     *
     * @param arrMaxSize 数组的最多存储数据量
     */
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        /*指向队列头部，分析出front是指向队列头的前一个位置.*/
        front = -1;
        /*指向队列尾，指向队列尾的数据(即就是队列最后一个数据)*/
        rear = -1;
    }
}
