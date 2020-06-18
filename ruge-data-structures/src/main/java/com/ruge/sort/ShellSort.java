package com.ruge.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 希尔排序
 * @date 2020/6/17 20:30
 */
public class ShellSort {
    // 使用逐步推导的方式来编写希尔排序
    // 希尔排序时， 对有序序列在插入时采用交换法,
    // 思路(算法) ===> 代码
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0;
        // 根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }


    public static LocalDateTime start;
    public static LocalDateTime end;
    public static int[] arr = new int[80000];

    @Before
    public void before() {
        start = LocalDateTime.now();
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 90000); //生成一个[0, 90000) 数
        }
    }

    @Test
    public void test1() {
        shellSort(arr);
    }

    @Test
    public void test2() {
        shellSort2(arr);
    }

    @After
    public void after() {
        end = LocalDateTime.now();
        System.out.println("希尔排序耗时:"+Duration.between(start, end).toMillis());
    }
}
