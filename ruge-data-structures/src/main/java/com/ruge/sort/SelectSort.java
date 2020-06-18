package com.ruge.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 选择排序
 * @date 2020/6/16 21:50
 */
public class SelectSort {


    public static void selectSort(int[] arr) {
        //选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }

            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
         //   System.out.println("选择排序~第" + (i + 1) + "轮后~~" + Arrays.toString(arr));
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
        selectSort(arr);
    }

    @After
    public void after() {
        end = LocalDateTime.now();
        System.out.println("选择排序耗时:"+Duration.between(start, end).toMillis());
    }
}
