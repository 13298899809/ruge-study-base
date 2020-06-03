package com.ruge.threadOutInput;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 生产者 消费者 实体类
 * @date 2020/5/31 21:45
 */
@Data
public class Res {
    private int id;
    public String userName;
    public String sex;
    // 表示共享资源对象是否为空，如果为 true，表示需要生产，如果为 false，则有数据了，不要生产
    public boolean isEmpty = false;
}
