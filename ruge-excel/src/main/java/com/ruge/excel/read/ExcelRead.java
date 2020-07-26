package com.ruge.excel.read;

import com.ruge.excel.ExcelEnum;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import java.io.FileInputStream;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/7/18 17:32
 */
public class ExcelRead {
    /**
     * @param path      路径
     * @param excelEnum excel 类型
     * @throws Exception {@link Exception}
     */
    public static void read(String path, ExcelEnum excelEnum) throws Exception {
        //1 创建工作簿
        Workbook workbook;
        FileInputStream fileInputStream;
        FormulaEvaluator evaluator;
        switch (excelEnum) {
            case excel2003:
                path = path + "03.xls";
                fileInputStream = new FileInputStream(path);
                workbook = new HSSFWorkbook(fileInputStream);
                evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                break;
            case excel2007:
                path = path + "07.xlsx";
                fileInputStream = new FileInputStream(path);
                workbook = new XSSFWorkbook(fileInputStream);
                evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + excelEnum);
        }

        Sheet sheet = workbook.getSheetAt(0);
        // 获取第一行
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) {
            // 获取一共多少行
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int rowNum = 1; rowNum < rowCount; rowNum++) {
                Row rowData = sheet.getRow(rowNum); //取出对应的行
                if (rowData != null) {
                    // 获取一共多少列
                    int cellCount = rowTitle.getPhysicalNumberOfCells();
                    for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                        //System.out.print("[" + (rowNum + 1 + "-" + (cellNum + 1) + "]"));
                        Cell cell = rowData.getCell(cellNum);
                        //匹配数据类型
                        if (cell != null) {
                            int cellType = cell.getCellType();
                            switch (cellType) {
                                case XSSFCell.CELL_TYPE_STRING:
                                    System.out.print("字符串：" + cell.getStringCellValue());
                                    break;
                                case XSSFCell.CELL_TYPE_BOOLEAN:
                                    System.out.print("布尔：" + cell.getBooleanCellValue());
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                        System.out.print("日期格式：" + new DateTime(cell.getDateCellValue()).toString("yyyy-MM-dd HH:mm:ss"));
                                        break;
                                    } else
                                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                                    System.out.print("整形：" + cell.toString());
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    System.out.print("空");
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    System.out.print("数据类型错误");
                                    break;
                                case Cell.CELL_TYPE_FORMULA:
                                    String formula = cell.getCellFormula();
                                    System.out.print("公式:" + formula);
                                    System.out.print(cell.getNumericCellValue());
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            System.out.print("空");
                        }
                    }
                }
            }
        }
    }
}
