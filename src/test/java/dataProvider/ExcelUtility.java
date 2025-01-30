package dataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
   String testDataPath="./DataDriven/dataDrivenForResrAssured.xlsx";
  
public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
	   FileInputStream fis = new FileInputStream(testDataPath);
	   Workbook wb = WorkbookFactory.create(fis);
	   String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	   wb.close();
	   return data;
   }

public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(testDataPath);
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount = wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;
 }

public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException {
	   FileInputStream fis = new FileInputStream(testDataPath);
	   Workbook wb = WorkbookFactory.create(fis);
	   Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
   	   cell.setCellValue(data);
	   FileOutputStream fos = new FileOutputStream(testDataPath);
	   wb.write(fos);
	   wb.close();
}
}
