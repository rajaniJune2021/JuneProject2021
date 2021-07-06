package commonUtilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ReadExcelFileUtility {

    public String getData(String sheetName, int rowName, int cellName) {
     String cellData = null;
        try {
            String excelSheetPath = System.getProperty("user.dir") + "/src/main/resources/LoginData.xlsx";
            File file = new File(excelSheetPath);
            FileInputStream fileInputStream = new FileInputStream(file);
//            Workbook wb = WorkbookFactory.create(file);
//            Sheet sheet = wb.getSheet(sheetName);
//            Row row = sheet.getRow(rowName);
//            Cell cell = row.getCell(cellName);
//            cellData = cell.getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellData;
    }

    public void writeDataToExcel(String sheetName, int rowNum, int cellName, String data){
        try{
            String excelSheetPath =  "C:\\Newfolder\\ExecutionStatus.xlsx";
            File file = new File(excelSheetPath);
            FileInputStream fileInputStream = new FileInputStream(file);
//            Workbook wb = WorkbookFactory.create(file);
//            Sheet sheet = wb.createSheet(sheetName);
//            Row row = sheet.createRow(rowNum);
//            Cell cell = row.createCell(cellName);
//            cell.setCellValue(data);
//            FileOutputStream fileOutputStream = new FileOutputStream(excelSheetPath);
//            wb.write(fileOutputStream);
//            fileOutputStream.close();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            XSSFSheet sheet = xssfWorkbook.createSheet(sheetName);
            XSSFRow row = sheet.createRow(rowNum);
            Cell cell = row.createCell(cellName);
            cell.setCellValue(data);
            FileOutputStream fos = new FileOutputStream(new File(excelSheetPath));
            xssfWorkbook.write(fos);
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}