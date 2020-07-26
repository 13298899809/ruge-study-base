package com.ruge.excel.write;

import com.ruge.excel.ExcelEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcelWriteTest {
    public static final String path = "D:\\google\\统计表";


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void write() {
        try {
            ExcelWrite.write(path, ExcelEnum.excel2007);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * -Xmx1024m -enableassertions -server -XX:MaxPermSize=1024m
     * 数据量  版本   耗时
     * 65535 2003  3535
     * 65535 2007  30484
     * 100000 2007  49105
     * 100000 super  5891
     */
    @Test
    public void writeBigData() {
        long start = System.currentTimeMillis();
        try {
            ExcelWrite.writeBigData(path, ExcelEnum.excelSuper, 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}