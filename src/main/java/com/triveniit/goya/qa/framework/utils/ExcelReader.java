package com.triveniit.goya.qa.framework.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class ExcelReader {
    private Workbook workbook = null;

    public ExcelReader(String fileName) {
        File file = new File(fileName);
        try {
            FileInputStream fileStream = new FileInputStream(file);
            if (FilenameUtils.getExtension(fileName).equals("xlsx")) {
                workbook = new XSSFWorkbook(fileStream);
            } else if(FilenameUtils.getExtension(fileName).equals("xls")) {
                workbook = new HSSFWorkbook(fileStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String[] getExcelRowData(String sheetName, int row) {
        String[] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelRowData(sheetIndex, row);
        }
        return data;
    }


    public String[] getExcelRowData(int sheetNumber, int row) {
        String[] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetNumber);
            if (sheet != null) {
                int cols = sheet.getRow(row).getPhysicalNumberOfCells();
                data = new String[cols];
                for (int i = 0; i < cols; i++) {
                    Cell cell = sheet.getRow(row).getCell(i);
                    String cellData = getData(cell).toString();
                    data[i] = cellData;
                }
            }
        }
        return data;
    }


    public String[] getExcelColData(String sheetName, int col) {
        String[] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelColData(sheetIndex, col);
        }
        return data;
    }


    public String[] getExcelColData(int sheetNumber, int col) {
        String[] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetNumber);
            if (sheet != null) {
                int rows = sheet.getLastRowNum() + 1;
                data = new String[rows];
                for (int i = 0; i < rows; i++) {
                    Cell cell = sheet.getRow(i).getCell(col);
                    String cellData = getData(cell).toString();
                    data[i] = cellData;
                }
            }
        }
        return data;
    }


    public String getExcelCellData(String sheetName, int row, int col) {
        String data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelCellData(sheetIndex, row, col);
        }
        return data;
    }


    public String getExcelCellData(int sheetNumber, int row, int col) {
        String data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetNumber);
            if (sheet != null) {
                Cell cell = sheet.getRow(row).getCell(col);
                data = getData(cell).toString();
            }
        }
        return data;
    }


    public String[][] getExcelSheetData(String sheetName) {
        String[][] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelSheetData(sheetIndex);
        }
        return data;
    }


    public String[][] getExcelSheetData(int sheetIndex) {
        String[][] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            if (sheet != null) {
                int rows = sheet.getLastRowNum() + 1;
                int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
                data = new String[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        Cell cell = sheet.getRow(i).getCell(j);
                        String cellData = getData(cell).toString();
                        data[i][j] = cellData;
                    }
                }
            }
        }
        return data;
    }


    public String[][] getExcelSheetData(String sheetName, boolean skipHeaderRow) {
        String[][] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelSheetData(sheetIndex, skipHeaderRow);
        }
        return data;
    }


    public String[][] getExcelSheetData(int sheetIndex, boolean skipHeaderRow) {
        String[][] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            if (sheet != null) {
                if (skipHeaderRow) {
                    int rows = sheet.getLastRowNum();
                    int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
                    data = new String[rows][cols];
                    for (int i = 1; i <= rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            Cell cell = sheet.getRow(i).getCell(j);
                            String cellData = getData(cell).toString();
                            data[i - 1][j] = cellData;
                        }
                    }
                } else {
                    int rows = sheet.getLastRowNum() + 1;
                    int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
                    data = new String[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            Cell cell = sheet.getRow(i).getCell(j);
                            String cellData = getData(cell).toString();
                            data[i][j] = cellData;
                        }
                    }
                }
            }
        }
        return data;
    }


    private Object getData(Cell cell) {
        Object result = null;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    result = "" + cell.getNumericCellValue();
                    break;
                case STRING:
                    result = "" + cell.getStringCellValue();
                    break;
                case BLANK:
                    result = "";
                    break;
                default: {
                    System.out.println("******************************************************************");
                    System.out.println("Cell [" + cell.getRowIndex() + "," + cell.getColumnIndex() + "]");
                    System.out.println("Cell Type: " + cell.getCellTypeEnum());
                    System.out.println("Cell Type is not supported");
                    System.out.println("Using default as BLANK");
                    System.out.println("******************************************************************");
                    result = "";
                    break;
                }
            }
        }
        return result;
    }
}





















