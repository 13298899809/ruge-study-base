package com.ruge.linkedlist;

import java.util.Stack;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 演示栈Stack的基本使用
 * @date 2020/6/14 10:40
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        // 出栈
        // smith, tom , jack
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }
    }
}
