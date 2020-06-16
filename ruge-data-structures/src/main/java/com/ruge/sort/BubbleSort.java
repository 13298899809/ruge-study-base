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
 * @Description: 冒泡排序
 * @date 2020/6/16 21:08
 */
public class BubbleSort {

    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
          //  System.out.println("冒泡排序~第" + (i + 1) + "趟排序后的数组:" + Arrays.toString(arr));
        }
    }

    public static void bubbleSort2(int[] arr) {
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        int temp; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        /*
         * 总排序次数 arr.length - 1
         * 单次排序次数 arr.length - 1 - i
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("冒泡排序~第" + (i + 1) + "趟排序后的数组:" + Arrays.toString(arr));
            // 在一趟排序中，一次交换都没有发生过
            if (!flag) {
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
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
    /*    for (int i = 100; i > 0; i--) {
            arr[100-i] = i;
        }*/
    }

    @Test
    public void test1() {
        bubbleSort1(arr);
    }

    @Test
    public void test2() {
        bubbleSort2(arr);
    }

    @After
    public void after() {
        end = LocalDateTime.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
}
