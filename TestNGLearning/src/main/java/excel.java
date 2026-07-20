import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class excel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Workbook sample = new HSSFWorkbook();
		
		FileInputStream file = new FileInputStream("D:\\OneDrive - inesri\\important docs\\automation_docs\\sample.xlsx");
		
		Sheet sheet = sample.getSheet("wow");
		
		Row r = sheet.getRow(0);
		
		System.out.println(r.getCell(1));
	}

}
