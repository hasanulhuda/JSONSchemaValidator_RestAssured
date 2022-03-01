package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    public static void main(String[] args) throws IOException {
        getRowCount();
        getCellData();
    }

    public static void getCellData(){
        try {
            String excelPath = "./data/TestData.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            String value = sheet.getRow(0).getCell(0).getStringCellValue();
            System.out.println(value);

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }


    public static void getRowCount() {
        try {

            String excelPath = "./data/TestData.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows: " + rowCount);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }


    }
}
