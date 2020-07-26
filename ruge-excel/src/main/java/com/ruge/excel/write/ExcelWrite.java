package com.ruge.excel.write;

import com.ruge.excel.ExcelEnum;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import java.io.FileOutputStream;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: excel 03 写入
 * @date 2020/7/18 11:20
 */
public class ExcelWrite {
    /**
     * @param path      输出路径
     * @param excelEnum 输出的excel版本
     * @throws Exception io异常
     */
    public static void write(String path, ExcelEnum excelEnum) throws Exception {
        //1 创建工作簿
        Workbook workbook = null;
        switch (excelEnum) {
            case excel2003:
                workbook = new HSSFWorkbook();
                path = path + "03.xls";
                break;
            case excel2007:
                workbook = new XSSFWorkbook();
                path = path + "07.xlsx";
                break;
        }
        //2 创建工作表
        Sheet sheet = workbook.createSheet("测试统计表");
        //3 创建行
        Row row1 = sheet.createRow(0);
        // 4 创建单元格
        Cell cell = row1.createCell(0);
        // 5 给单元格赋值
        cell.setCellValue("表格创建时间");

        //3 创建行
        Row row2 = sheet.createRow(1);
        // 4 创建单元格
        Cell cell2 = row2.createCell(0);
        // 5 给单元格赋值
        cell2.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        //生成一张表 03是xls 07是xlsx
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    /**
     * @param path      输出路径
     * @param excelEnum excel版面
     * @param size      写入数据量
     * @throws Exception 异常
     */
    public static void writeBigData(String path, ExcelEnum excelEnum, long size) throws Exception {
        //1 创建工作簿
        Workbook workbook = null;
        switch (excelEnum) {
            case excel2003:
                workbook = new HSSFWorkbook();
                path = path + "03.xls";
                break;
            case excel2007:
                workbook = new XSSFWorkbook();
                path = path + "07.xlsx";
                break;
            case excelSuper:
                workbook = new SXSSFWorkbook();
                path = path + "super.xlsx";
                break;
        }
        //2 创建工作表
        Sheet sheet = workbook.createSheet("测试统计表");
        for (int rowNum = 0; rowNum < size; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue("张" + rowNum + "王" + rowNum);
            }
        }
        //生成一张表 03是xls 07是xlsx
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
