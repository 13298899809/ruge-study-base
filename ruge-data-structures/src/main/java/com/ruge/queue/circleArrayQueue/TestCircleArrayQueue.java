package com.ruge.queue.circleArrayQueue;

import java.util.Scanner;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 循环队列
 * @date 2020/6/13 17:06
 */
public class TestCircleArrayQueue {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");
        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置4, 其队列的有效数据最大是3
        char key; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    CircleArrayUtil.showQueue(queue);
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    CircleArrayUtil.addQueue(queue, value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = CircleArrayUtil.getQueue(queue);
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = CircleArrayUtil.headQueue(queue);
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
