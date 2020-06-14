package com.ruge.linkedlist.DoubleLinkedList;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 双向链表工具类
 * @date 2020/6/14 19:53
 */
public class DoubleNodeTool {
    /**
     * 先初始化一个头节点, 头节点不要动, 不存放具体的数据
     */
    private static DoubleNode head = new DoubleNode(0, "", "");

    /**
     * @return {@link DoubleNode} 返回头节点
     */
    public static DoubleNode getHead() {
        return head;
    }

    /**
     * 双向链表遍历
     */
    public static void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        DoubleNode temp = head.next;
        while (temp != null) {
            // 判断是否到链表最后
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }

    /**
     * 添加一个节点到双向链表的最后.
     *
     * @param doubleNode {@link DoubleNode}
     */
    public static void add(DoubleNode doubleNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        DoubleNode temp = head;
        // 遍历链表，找到最后
        while (temp.next != null) {
            // 找到链表的最后
            // 如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = doubleNode;
        doubleNode.pre = temp;
    }


    /**
     * 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
     * @param doubleNode {@link DoubleNode}
     */
    public static void update(DoubleNode doubleNode) {
        // 判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点, 根据no编号
        // 定义一个辅助变量
        DoubleNode temp = head.next;
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; // 已经遍历完链表
            }
            if (temp.no == doubleNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = doubleNode.name;
            temp.nickname = doubleNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", doubleNode.no);
        }
    }


    /**
     *
     * @param no 链表的编号
     * 1 对于双向链表，我们可以直接找到要删除的这个节点
     * 2 找到后，自我删除即可
     */
    public static void delete(int no) {
        // 判断当前链表是否为空
        if (head.next == null) {// 空链表
            System.out.println("链表为空，无法删除");
            return;
        }
        // 辅助变量(指针)
        DoubleNode temp = head.next;
        // 标志是否找到待删除节点的
        boolean flag = false;
        while (true) {
            // 已经到链表的最后
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; // temp后移，遍历
        }
        // 判断flag
        if (flag) {
            // 可以删除
            // temp.next = temp.next.next;[单向链表]
            temp.pre.next = temp.next;
            // 这里我们的代码有问题?
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
}
