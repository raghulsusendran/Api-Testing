package SrcCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPrice {

	@Test
	public  void allPrice() {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");
		List<WebElement> row= driver.findElements(By.xpath("//table[@id='shopping']//tr"));
		int rowSize=row.size();
		List<WebElement> column =  driver.findElements(By.xpath("//table[@id='shopping']//th"));
		//xint columnSize=column.size();
		int postionOfPrice =  getFirstRow(row,column,driver);
		int totalPrice =0;
		for (int i = 1; i < rowSize; i++) {
				WebElement a1= driver.findElement(By.xpath("//table[@id=\"shopping\"]/tbody/tr["+(i)+"]/td["+(postionOfPrice)+"]"));
				String value=a1.getText();
				totalPrice = totalPrice + Integer.parseInt(value);
		}
		System.out.println("Total: "+totalPrice);
		WebElement allprice= driver.findElement(By.xpath("//*[@id=\"shopping\"]/tfoot/td[2]"));
		String finalprice=allprice.getText();
		int crxtprice=Integer.parseInt(finalprice);
		if (totalPrice==crxtprice) {
			System.out.println("Total is correct");
		}else System.out.println("Total is wrong");
        driver.quit();
	}

	private static int getFirstRow(List<WebElement> row, List<WebElement> column, WebDriver driver) {
			int columnSize = column.size();
			for (int j = 1; j <=columnSize; j++) {
				WebElement a1= driver.findElement(By.xpath("//table[@id=\"shopping\"]/thead/tr["+(1)+"]/th["+(j)+"]"));
				String value=a1.getText();
				System.out.println(value);
				if (value.equals("Price")) {
					 return j;
				}
			}
			return 0;
}
}