package com.ruge.stack.stackCalculator;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 栈计算器
 * @date 2020/6/14 21:53
 */
@Data
public class StackCalculator {

    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;// top表示栈顶，初始化为-1

    //构造器
    public StackCalculator(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
}
