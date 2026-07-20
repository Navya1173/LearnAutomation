package testUsingParameter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class paramsxml {

	public void main()throws Exception {

	Workbook sample = new HSSFWorkbook();
	
	FileInputStream file = new FileInputStream("TestNGLearning/dat/sample.xlsx");
	
	Sheet sheet = sample.getSheet("Sheet1");
	
	Row r = sheet.getRow(0);
	
	System.out.println(r.getCell(1));

	}
	
}
