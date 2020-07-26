package com.ruge.excel.converter;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/7/18 22:18
 */
public class RugeCellStyleStrategy extends AbstractCellStyleStrategy implements RowWriteHandler {

    private List<CellStyle> contentCellStyleList = new ArrayList<>();

    private List<WriteCellStyle> contentWriteCellStyleList = new ArrayList<>();

    public int maxCellIndex;

    public RugeCellStyleStrategy(int maxCellIndex) {
        this.maxCellIndex = maxCellIndex;
    }

    /**
     * Initialization cell style
     *
     * @param workbook
     */
    @Override
    protected void initCellStyle(Workbook workbook) {
        WriteCellStyle contentWriteCellStyle1 = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        contentWriteCellStyle1.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        contentWriteCellStyle1.setFillForegroundColor(IndexedColors.GREEN.getIndex());


        WriteCellStyle contentWriteCellStyle2 = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        contentWriteCellStyle2.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        contentWriteCellStyle2.setFillForegroundColor(IndexedColors.ORANGE.getIndex());

        contentCellStyleList.add(StyleUtil.buildContentCellStyle(workbook, contentWriteCellStyle1));
        contentCellStyleList.add(StyleUtil.buildContentCellStyle(workbook, contentWriteCellStyle2));
    }

    /**
     * Sets the cell style of header
     *
     * @param cell
     * @param head
     * @param relativeRowIndex
     */
    @Override
    protected void setHeadCellStyle(Cell cell, Head head, Integer relativeRowIndex) {

    }

    /**
     * Sets the cell style of content
     *
     * @param cell
     * @param head
     * @param relativeRowIndex
     */
    @Override
    protected void setContentCellStyle(Cell cell, Head head, Integer relativeRowIndex) {

    }

    /**
     * Called before create the row
     *
     * @param writeSheetHolder
     * @param writeTableHolder Nullable.It is null without using table writes.
     * @param rowIndex
     * @param relativeRowIndex Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void beforeRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Integer rowIndex, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * Called after the row is created
     *
     * @param writeSheetHolder
     * @param writeTableHolder Nullable.It is null without using table writes.
     * @param row
     * @param relativeRowIndex Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void afterRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        int rowNum = row.getRowNum();
        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
        Cell cell = row.getCell(0);
        if (XSSFCell.CELL_TYPE_STRING == cell.getCellType() && "字符串0".equals(cell.getStringCellValue())) {
            int physicalNumberOfRows = cell.getSheet().getPhysicalNumberOfRows();
            row.getCell(0).setCellStyle(contentCellStyleList.get(0));
            row.getCell(1).setCellStyle(contentCellStyleList.get(0));
            row.getCell(2).setCellStyle(contentCellStyleList.get(0));
        }
    }

    /**
     * Called after all operations on the row have been completed.This method is not called when fill the data.
     *
     * @param writeSheetHolder
     * @param writeTableHolder Nullable.It is null without using table writes.
     * @param row
     * @param relativeRowIndex Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {

    }


}
