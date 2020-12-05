package Org.qsp.Genric;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Xl {
	public static String readCell(String path, String SheetName, int r, int c) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Cell cl = sh.getRow(r).getCell(c);
		return cl.toString();
	}

	@DataProvider
	public static String[][] readExcel() throws Exception {
		String[][] st;
		FileInputStream fis = new FileInputStream(BaseTest.XL_data + BaseTest.Xl_File);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(BaseTest.sheetName);
		int rowCount = sh.getPhysicalNumberOfRows();
		int colCount = sh.getRow(0).getLastCellNum();
		st = new String[rowCount - 1][colCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				Cell cl = sh.getRow(i).getCell(j);
				st[i - 1][j] = cl.getStringCellValue();
			}
		}
		return st;
	}
}
