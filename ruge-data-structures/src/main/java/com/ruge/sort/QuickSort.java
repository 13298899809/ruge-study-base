package com.ruge.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 快速排序
 * @date 2020/6/17 21:38
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，
            // 已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
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
        quickSort(arr, 0, arr.length - 1);
    }


    @After
    public void after() {
        end = LocalDateTime.now();
        System.out.println("快速排序耗时:" + Duration.between(start, end).toMillis());
    }
}
