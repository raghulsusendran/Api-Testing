package excelTest;

import org.testng.annotations.DataProvider;

public class DataUtits {

	@DataProvider(name="getdata" , parallel = !true)
	public String[][] getData() {
	 String[][] dataexcel = dataRead.getdataexcel();
		
//		String[][] data= new String[3][2];
//		
//		data[0][0]="dravid123@gmail.com";
//		data[0][1]="Dravid@123";
//		
//		data[1][0]="dhoni234@gmail.com";
//		data[1][1]="Dhoni@234";
//		
//		data[2][0]="123567";
//		data[2][1]="password";
//				
		return dataexcel;
     
		
      }

   }
