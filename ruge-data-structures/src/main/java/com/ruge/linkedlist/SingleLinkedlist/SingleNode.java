package com.ruge.linkedlist.SingleLinkedlist;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 单项链表
 * @date 2020/6/14 10:51
 */
@Data
public class SingleNode {
    public int no;
    public String name;
    public String nickname;
    /*指向下一个节点*/
    public SingleNode next;

    public SingleNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
