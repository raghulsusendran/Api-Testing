package SrcCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class QaTable {
    
	
	//To locate an row and column no:
	@Test
	public static void Table(){
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/");
        driver.findElement(By.id("customers"));
		List<WebElement> row= driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowSize=row.size();
		List<WebElement> column =  driver.findElements(By.xpath("//table[@id='customers']//th"));
		int columnSize=column.size();
		
		for (int i = 1; i < rowSize; i++) {
			for (int j = 1; j <=columnSize; j++) {
				WebElement a1= driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+(i+1)+"]/td["+(j)+"]"));
				String value=a1.getText();
				if (value.equals("Bangalore")) {
					System.out.println(i +":"+ j);
					
				}
			}
		}
		//driver.quit();
		
		
	}
	
		
		
	}


