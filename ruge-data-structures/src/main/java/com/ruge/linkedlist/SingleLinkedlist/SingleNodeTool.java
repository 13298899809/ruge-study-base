package com.ruge.linkedlist.SingleLinkedlist;


import java.util.Stack;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 单项链表工具类
 * @date 2020/6/14 10:55
 */
public class SingleNodeTool {

    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    public static SingleNode head = new SingleNode(0, "", "");

    /**
     * 给单项链表添加数据
     * 不考虑排序
     * 找到当前链表的最后一个节点
     * 将最后节点的next指向新的节点
     *
     * @param singleNode {@link SingleNode}
     */
    public static void add(SingleNode singleNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        SingleNode temp = head;
        //遍历链表，找到最后
        while (temp.next != null) {
            //找到链表的最后
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = singleNode;
    }


    /**
     * 有序插入
     * 根据排名将英雄插入到指定位置
     *
     * @param singleNode {@link SingleNode}
     */
    public static void addByOrder(SingleNode singleNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        SingleNode temp = head;
        // flag标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            //说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > singleNode.no) {
                break;
                //说明希望添加的heroNode的编号已然存在
            } else if (temp.next.no == singleNode.no) {
                //说明编号存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        //不能添加，说明编号存在
        if (flag) {
            System.out.println("准备插入的英雄的编号 %d 已经存在了, 不能加入：  " + singleNode.no);
        } else {
            //插入到链表中, temp的后面
            singleNode.next = temp.next;
            temp.next = singleNode;
        }
    }

    /**
     * @return {@link SingleNode} 返回头节点
     */
    public static SingleNode getHead() {
        return head;
    }

    /**
     * 显示链表[遍历]
     */
    public static void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        SingleNode temp = head.next;
        while (temp != null) {
            //判断是否到链表最后
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }


    /**
     * 修改节点的信息, 根据no编号来修改，即no编号不能改.
     * 1. 根据 newSingleNode 的 no 来修改即可
     *
     * @param newSingleNode {@link SingleNode}
     */
    public static void update(SingleNode newSingleNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        SingleNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.no == newSingleNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newSingleNode.name;
            temp.nickname = newSingleNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newSingleNode.no);
        }
    }


    /**
     * 1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
     *
     * @param no 链表编号
     */
    public static void delete(int no) {
        SingleNode temp = head;
        // 标志是否找到待删除节点的
        boolean flag = false;
        while (true) {
            //已经到链表的最后
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            //temp后移，遍历
            temp = temp.next;
        }
        //判断flag
        if (flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }


    /**
     * 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(SingleNode head) {
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        SingleNode cur = head.next;
        while (cur != null) {
            length++;
            //遍历
            cur = cur.next;
        }
        return length;
    }


    /**
     * @param head  {@link SingleNode}
     * @param index 倒数的索引
     * @return 查找单链表中的倒数第k个结点 【新浪面试题】
     * 1. 编写一个方法，接收head节点，同时接收一个index
     * 2. index 表示是倒数第index个节点
     * 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
     * 5. 如果找到了，则返回该节点，否则返回nulll
     */
    public static SingleNode findLastIndexNode(SingleNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;//没有找到
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        SingleNode cur = head.next; //3 // 3 - 1 = 2
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    /**
     * 将单链表反转
     *
     * @param head {@link SingleNode}
     */
    public static void reversetList(SingleNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        SingleNode cur = head.next;
        // 指向当前节点[cur]的下一个节点
        SingleNode next;
        SingleNode reverseHead = new SingleNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while (cur != null) {
            //先暂时保存当前节点的下一个节点，因为后面需要使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur 连接到新的链表上
            reverseHead.next = cur;
            //让cur后移
            cur = next;
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }


    /**
     * 单项链表翻转
     *
     * @param head {@link SingleNode}
     *             可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
     */
    public static void reversePrint(SingleNode head) {
        if (head.next == null) {
            return;//空链表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<SingleNode> stack = new Stack<>();
        SingleNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            //cur后移，这样就可以压入下一个节点
            cur = cur.next;
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            //stack的特点是先进后出
            System.out.println(stack.pop());
        }
    }
}
