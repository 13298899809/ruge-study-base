package com.ruge.linkedlist.SingleLinkedlist;

import org.junit.After;
import org.junit.Test;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 单项链表测试
 * @date 2020/6/14 10:59
 */
public class TestSingleNode {


    public void init() {
        SingleNode hero1 = new SingleNode(1, "宋江", "及时雨");
        SingleNode hero3 = new SingleNode(3, "吴用", "智多星");
        SingleNode hero2 = new SingleNode(2, "卢俊义", "玉麒麟");
        SingleNode hero4 = new SingleNode(4, "林冲", "豹子头");
        SingleNodeTool.add(hero1);
        SingleNodeTool.add(hero4);
        SingleNodeTool.add(hero2);
        SingleNodeTool.add(hero3);

    }

    public void initBySort() {
        SingleNode hero1 = new SingleNode(1, "宋江", "及时雨");
        SingleNode hero3 = new SingleNode(3, "吴用", "智多星");
        SingleNode hero2 = new SingleNode(2, "卢俊义", "玉麒麟");
        SingleNode hero4 = new SingleNode(4, "林冲", "豹子头");
        SingleNodeTool.addByOrder(hero1);
        SingleNodeTool.addByOrder(hero4);
        SingleNodeTool.addByOrder(hero2);
        SingleNodeTool.addByOrder(hero3);

    }

    /**
     * 无序插入
     */
    @Test
    public void testInit() {
        init();
    }

    /**
     * 有序插入
     */
    @Test
    public void testInitBySort() {
        initBySort();
    }

    /**
     * 节点修改
     */
    @Test
    public void testUpdate() {
        initBySort();
        SingleNode hero4 = new SingleNode(4, "公孙胜", "入云龙");
        SingleNodeTool.update(hero4);
    }

    /**
     * 节点删除
     */
    @Test
    public void testDelete() {
        initBySort();
        SingleNodeTool.delete(2);
    }

    /**
     * 获取头节点
     */
    @Test
    public void testGetHead() {
        initBySort();
        SingleNode head = SingleNodeTool.getHead();
        System.out.println("头节点" + head);
    }

    /**
     * 获取链表长度
     */
    @Test
    public void testGetLength() {
        initBySort();
        SingleNode head = SingleNodeTool.getHead();
        System.out.println(SingleNodeTool.getLength(head));
    }

    /**
     * 查找单链表中的倒数第k个结点
     */
    @Test
    public void testGetLastIndexNode() {
        initBySort();
        SingleNode head = SingleNodeTool.getHead();
        System.out.println(SingleNodeTool.findLastIndexNode(head, 2));
    }

    /**
     * 单项链表翻转
     */
    @Test
    public void testReverList() {
        initBySort();
        SingleNode head = SingleNodeTool.getHead();
        SingleNodeTool.reversetList(head);
    }

    /**
     * 单链表逆序打印
     */
    @Test
    public void testReverPrint() {
        initBySort();
        SingleNode head = SingleNodeTool.getHead();
        SingleNodeTool.reversePrint(head);
        System.out.println("逆序打印结束~~~");
    }

    /**
     * 单项链表简单遍历
     */
    @After
    public void testList() {
        SingleNodeTool.list();
    }
}
