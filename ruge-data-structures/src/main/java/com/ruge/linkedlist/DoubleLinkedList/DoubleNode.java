package com.ruge.linkedlist.DoubleLinkedList;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 双向节点
 * @date 2020/6/14 19:52
 */
@Data
public class DoubleNode {
    public int no;
    public String name;
    public String nickname;
    // 指向下一个节点, 默认为null
    public DoubleNode next;
    // 指向前一个节点, 默认为null
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
