package com.ruge.excel.read;

import com.ruge.excel.ExcelEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcelReadTest {
    public static final String path = "D:\\google\\读取测试";
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void read() throws Exception {
        ExcelRead.read(path, ExcelEnum.excel2003);
    }
}