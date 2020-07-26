package com.ruge.excel.write;

import com.alibaba.excel.util.FileUtils;
import com.ruge.excel.entity.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyExcelWriteTest {
    public static List<DemoData> list = new ArrayList<DemoData>();
    public static List<IndexData> listIndex = new ArrayList<>();
    public static List<ComplexHeadData> listComplexHead = new ArrayList<>();
    public static List<ConverterData> listConverterData = new ArrayList<>();
    public static List<ImageData> listImageData = new ArrayList<>();
    public static List<WidthAndHeightData> listWidthAndHeightData = new ArrayList<>();
    public static List<DemoStyleData> listDemoStyleData = new ArrayList<>();
    public static final String path = "D:\\google\\simpleWrite.xlsx";

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate2(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }

        for (int i = 0; i < 10; i++) {
            listIndex.add(IndexData.builder().string("张" + i).date(new Date()).doubleData(0.123).build());
            listComplexHead.add(ComplexHeadData.builder().string("张" + i).date(new Date()).doubleData(0.123).build());
            listConverterData.add(ConverterData.builder().string("张" + i).date(new Date()).doubleData(0.123).build());
            listWidthAndHeightData.add(WidthAndHeightData.builder().string("张" + i).date(new Date()).doubleData(0.123).build());
            listDemoStyleData.add(DemoStyleData.builder().string("张" + i).date(new Date()).doubleData(0.123).build());
        }

        // 放入五种类型的图片 实际使用只要选一种即可
        String imagePath = "D:\\google\\sun.jpg";
        listImageData.add(ImageData.builder().file(new File(imagePath)).build());
        listImageData.add(ImageData.builder().string(imagePath).build());
        listImageData.add(ImageData.builder().inputStream(FileUtils.openInputStream(new File(imagePath))).build());
        listImageData.add(ImageData.builder().byteArray(FileUtils.readFileToByteArray(new File(imagePath))).build());
        listImageData.add(ImageData.builder().url(new URL("https://pic2.zhimg.com/80/c474879a2ecd1baf9a28caad41deacc9_720w.jpg?source=1940ef5c")).build());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void simpleWrite() {
        EasyExcelWrite.simpleWrite(path, list);
    }

    @Test
    public void excludeOrIncludeWrite() {
        EasyExcelWrite.excludeOrIncludeWrite(path, list);
    }

    @Test
    public void indexWrite() {
        EasyExcelWrite.indexWrite(path, listIndex);
    }

    @Test
    public void complexHeadWrite() {
        EasyExcelWrite.complexHeadWrite(path, listComplexHead);
    }

    @Test
    public void repeatedWrite() {
        EasyExcelWrite.repeatedWrite(path, list, listComplexHead);
    }

    @Test
    public void converterWrite() {
        EasyExcelWrite.converterWrite(path, listConverterData);
    }

    @Test
    public void imageWrite() {
        EasyExcelWrite.imageWrite(path, listImageData);
    }


    @Test
    public void widthAndHeightWrite() {
        EasyExcelWrite.widthAndHeightWrite(path, listWidthAndHeightData);
    }

    @Test
    public void annotationStyleWrite() {
        EasyExcelWrite.annotationStyleWrite(path, listDemoStyleData);
    }

    @Test
    public void handlerStyleWrite() {
        EasyExcelWrite.handlerStyleWrite(path, list);
    }
}