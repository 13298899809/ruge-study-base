package com.ruge.linkedlist.JosephCircle.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 数组解决约瑟夫问题
 * @date 2020/6/14 20:22
 */
public class TestJosephCircleList {
    public static void main(String[] args) {
        //定义一个容器
        List<Integer> list=new ArrayList<>();
        //赋值
        for(int i=1;i<=100;i++) {
            list.add(i);
        }
        //计数
        int count=1;
        //容器中只要还多余1个数，就一直循环
        while(list.size()!=2) {
            //for循环找出剩下的报数m的下标
            for(int i=0;i<list.size();i++) {
                if(count==5) {
                    Integer remove = list.remove(i);
                    i--;
                    System.out.println("出圈编号:"+remove);
                    count=0;
                }
                count++;
            }
        }
        System.out.println();
        for (Integer integer : list) {
            System.out.print("最后赢家：" + integer);
        }
    }
}
