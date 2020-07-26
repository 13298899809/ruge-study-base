package com.ruge.excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 复杂头数据.这里最终效果是第一行就一个主标题，第二行分类
 * @date 2020/7/18 21:21
 */
@Builder
@Data
public class ComplexHeadData {
    @ExcelProperty({"主标题", "字符串标题"})
    private String string;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "数字标题"})
    private Double doubleData;
}

