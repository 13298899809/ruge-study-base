package com.ruge.stack.arrayStack;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 数组实现栈
 * @date 2020/6/14 21:09
 */
@Data
public class ArrayStack {

    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;// top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
}
