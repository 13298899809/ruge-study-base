package com.ruge.linkedlist.DoubleLinkedList;

import com.ruge.linkedlist.SingleLinkedlist.SingleNode;
import com.ruge.linkedlist.SingleLinkedlist.SingleNodeTool;
import org.junit.After;
import org.junit.Test;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 双向链表 测试
 * @date 2020/6/14 20:01
 */
public class TestDoubleNode {

    public void init() {
        DoubleNode hero1 = new DoubleNode(1, "宋江", "及时雨");
        DoubleNode hero3 = new DoubleNode(3, "吴用", "智多星");
        DoubleNode hero2 = new DoubleNode(2, "卢俊义", "玉麒麟");
        DoubleNode hero4 = new DoubleNode(4, "林冲", "豹子头");
        DoubleNodeTool.add(hero1);
        DoubleNodeTool.add(hero4);
        DoubleNodeTool.add(hero2);
        DoubleNodeTool.add(hero3);

    }


    /**
     * 无序插入
     */
    @Test
    public void testInit() {
        init();
    }


    /**
     * 节点修改
     */
    @Test
    public void testUpdate() {
        init();
        DoubleNode hero4 = new DoubleNode(4, "公孙胜", "入云龙");
        DoubleNodeTool.update(hero4);
    }

    /**
     * 节点删除
     */
    @Test
    public void testDelete() {
        init();
        DoubleNodeTool.delete(2);
    }

    /**
     * 获取头节点
     */
    @Test
    public void testGetHead() {
        init();
        DoubleNode head = DoubleNodeTool.getHead();
        System.out.println("头节点" + head);
    }


    /**
     * 双项链表简单遍历
     */
    @After
    public void testList() {
        DoubleNodeTool.list();
    }
}
