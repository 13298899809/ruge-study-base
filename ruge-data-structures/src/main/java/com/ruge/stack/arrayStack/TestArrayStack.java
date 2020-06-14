package com.ruge.stack.arrayStack;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/14 21:13
 */
public class TestArrayStack {

    /**
     * 栈的测试
     */
    @Test
    public void testStack() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 1; i <= 5; i++) {
            ArrayStackTool.push(stack, i);
        }
        System.out.println("入栈后的遍历");
        ArrayStackTool.list(stack);
        /*出栈一条数据*/
        ArrayStackTool.pop(stack);
        System.out.println("出后的遍历");
        ArrayStackTool.list(stack);
    }

    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key;
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    ArrayStackTool.list(stack);
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    ArrayStackTool.push(stack, value);
                    break;
                case "pop":
                    try {
                        int res = ArrayStackTool.pop(stack);
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}
