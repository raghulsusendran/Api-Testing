 package excelTest;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


  //Read Excel data
public class dataRead {

	public static String[][] getdataexcel()  {
     
		String filelocation ="./test-data/login.xlsx";
		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(filelocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFSheet sheet = book.getSheetAt(0);
		 int lastRowNum = sheet.getLastRowNum();
		 int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		 short lastCellNum = sheet.getRow(0).getLastCellNum();
		 System.out.println("No of rows"+" "+lastRowNum);
		 System.out.println("No of rows"+" "+physicalNumberOfRows);
		 System.out.println("No of column"+" "+lastCellNum);
		 String[][] data= new String[lastRowNum][lastCellNum];
		 
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCellNum ; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter df=new DataFormatter();
				String value = df.formatCellValue(cell);
				//String value2 = cell.getStringCellValue();
				System.out.println(value);
				data [i-1][j]=value;
			} 
		}
		
		return data;
	}

}
