package com.rmg.genericutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 * @author Nitheesha
 *
 */
public class ExcelUtility {

	/**
	 * This method used to get all the data from execl sheet 
	 * @param sheetName
	 * @return data
	 * @throws Throwable
	 */
	@DataProvider
	public Object[][] getAlldataFromExcelSheet(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./TestData/RMGTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=i+1;j<lastCell;j++) {
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
	
	
