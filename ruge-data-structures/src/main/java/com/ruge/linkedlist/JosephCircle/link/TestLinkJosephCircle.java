package com.ruge.linkedlist.JosephCircle.link;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 约瑟夫问题 测试类
 * @date 2020/6/14 20:18
 */
public class TestLinkJosephCircle {


    @Test
    public void test() {
        JosephCircleLinkedTool.addBoy(100);
        JosephCircleLinkedTool.countBoy(1, 5, 100);
    }

    @After
    public void list() {
        JosephCircleLinkedTool.showBoy();
    }
}
