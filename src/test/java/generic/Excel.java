package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {


	public static String getData(String sheet,int row,int cell) 
	{
		String val="";
		try{
		
		FileInputStream fis = new FileInputStream("./Excel/dataone.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
		
		 val = c.getStringCellValue();
		
	}catch(Exception e)
	{

	}
		return val;
		
	}
	
}
