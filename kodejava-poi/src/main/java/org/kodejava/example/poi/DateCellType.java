package org.kodejava.example.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DateCellType {
    public static void main(String[] args) throws Exception {
        String filename = "datecelltype.xls";

        try (FileInputStream fis = new FileInputStream(filename)) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);

            // Read a cell the first cell on the sheet.
            HSSFCell cell = sheet.getRow(0).getCell(0);
            if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                System.out.println("Cell type for date data type is numeric.");
            }

            // Using HSSFDateUtil to check if a cell contains a date.
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                System.out.println("The cell contains a date value: " + cell.getDateCellValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
