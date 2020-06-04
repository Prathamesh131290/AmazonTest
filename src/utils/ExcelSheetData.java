package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetData 
{
	static String filePath = System.getProperty("user.dir")+"\\src\\testdata\\UsersList.xlsx"; 
	
	public static String fetchData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		String value = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}
