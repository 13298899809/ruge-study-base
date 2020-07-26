package com.ruge.excel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.ruge.excel.converter.RugeCellStyleStrategy;
import com.ruge.excel.entity.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/7/18 19:07
 */
public class EasyExcelWrite {
    /**
     * @param path     路径
     * @param dataList 数据
     *                 <p>
     *                 最简单的写
     */
    public static void simpleWrite(String path, List<DemoData> dataList) {
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(path, DemoData.class).sheet("模板").doWrite(dataList);
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 根据参数只导出指定列
     */
    public static void excludeOrIncludeWrite(String fileName, List<DemoData> dataList) {
        // 根据用户传入字段 假设我们要忽略 date
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("date2");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("模板").doWrite(dataList);
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 使用{@link ExcelProperty}注解指定写入的列
     */
    public static void indexWrite(String fileName, List<IndexData> dataList) {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, IndexData.class).sheet("模板").doWrite(dataList);
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 复杂头写入
     *                 <p>
     *                 使用{@link ExcelProperty}注解指定复杂的头
     */
    public static void complexHeadWrite(String fileName, List<ComplexHeadData> dataList) {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(dataList);
    }

    /**
     * 重复多次写入
     *
     * @param fileName  路径
     * @param dataList1 数据
     * @param dataList2 数据
     *                  <p>
     *                  如果写到不同的sheet 不同的对象
     */
    public static void repeatedWrite(String fileName, List<DemoData> dataList1, List<ComplexHeadData> dataList2) {
        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName).build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面

            // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            excelWriter.write(dataList1, EasyExcel.writerSheet(0, "模板" + 0).head(DemoData.class).build());
            excelWriter.write(dataList1, EasyExcel.writerSheet(1, "模板" + 1).head(ComplexHeadData.class).build());
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 日期、数字或者自定义格式转换
     *                 <p>
     *                 创建excel对应的实体对象 参照{@link ConverterData}
     *                 <p>
     *                 使用{@link ExcelProperty}配合使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
     */
    public static void converterWrite(String fileName, List<ConverterData> dataList) {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ConverterData.class).sheet("模板").doWrite(dataList);
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 图片导出
     */
    public static void imageWrite(String fileName, List<ImageData> dataList) {
        EasyExcel.write(fileName, ImageData.class).sheet().doWrite(dataList);
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 使用注解{@link ColumnWidth}、{@link HeadRowHeight}、{@link ContentRowHeight}指定宽度或高度
     */
    public static void widthAndHeightWrite(String fileName, List<WidthAndHeightData> dataList) {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, WidthAndHeightData.class).sheet("模板").doWrite(dataList);
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 注解形式自定义样式
     *                 <p>
     *                 创建excel对应的实体对象 参照{@link DemoStyleData}
     */
    public static void annotationStyleWrite(String fileName, List<DemoStyleData> dataList) {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoStyleData.class).sheet("模板").doWrite(dataList);
    }

    /**
     * @param fileName 路径
     * @param dataList 数据
     *                 <p>
     *                 拦截器形式自定义样式
     *                 <p>
     *                 创建一个style策略 并注册
     */
    public static void handlerStyleWrite(String fileName, List<DemoData> dataList) {

        RugeCellStyleStrategy horizontalCellStyleStrategy = new RugeCellStyleStrategy(3);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).registerWriteHandler(horizontalCellStyleStrategy).sheet("模板").doWrite(dataList);
    }
}
