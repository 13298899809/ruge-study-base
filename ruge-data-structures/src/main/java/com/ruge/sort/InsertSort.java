package com.ruge.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 插入排序
 * @date 2020/6/17 20:28
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("第"+i+"轮插入");
            //System.out.println(Arrays.toString(arr));
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
        insertSort(arr);
    }

    @After
    public void after() {
        end = LocalDateTime.now();
        System.out.println("插入排序耗时:" + Duration.between(start, end).toMillis());
    }
}
