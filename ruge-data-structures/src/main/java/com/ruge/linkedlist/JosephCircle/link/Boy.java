package com.ruge.linkedlist.JosephCircle.link;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 约瑟夫环的人员
 * @date 2020/6/14 20:13
 */
@Data
public class Boy {
    private int no;// 编号
    private Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }
}
