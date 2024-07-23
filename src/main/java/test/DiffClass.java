package test;
import java.awt.Window;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DiffClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.get("https://www.google.com/");
//		driver.manage().window().maximize();
//		driver.switchTo().activeElement().sendKeys("boxing",Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		List<WebElement> games=driver.findElements(By.xpath("//*[contains(text(),'Boxing') or contains(text(),'boxing') ]"));
//		System.out.println(games.size());
		
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		driver.findElement(By.linkText("Simple table")).click();
		js.executeScript("window.scrollBy(0,500)");
		WebElement simtabel= driver.findElement(By.id("simpletable"));
		
		//print the title of the columns
		List<WebElement> elements=simtabel.findElements(By.tagName("th"));
		for (WebElement header : elements) {
			String headtext= header.getText();
			System.out.println(headtext);
		}
		
		//print the size of the rows 
		List<WebElement> rows= simtabel.findElements(By.cssSelector("tbody tr"));
		int a =rows.size();
		System.out.println(a);
		System.out.println();
		if(a==3) {
			System.out.println("pass");
		}else System.out.println("fail");
		
		//print all first name
//		for (WebElement row1 : rows) {
//			List<WebElement> column= row1.findElements(By.tagName("td"));
//			  WebElement clmn=column.get(0);
//			  System.out.println(clmn.getText());
//		}
		
//		//for all rows
//		for (WebElement mvcn : rows) {
//			String trv=mvcn.getText();
//			System.out.println(trv);
//		}
		
		
		//if raj is the lastname click the check box
		for (int i = 0; i < a; i++) {
			
			List<WebElement> all= rows.get(i).findElements(By.tagName("td"));
			WebElement lastname=all.get(1);
			 String lname= lastname.getText();
			 System.out.println(lname);
			 if (lname.equals("Raj")) {
				
				 WebElement check= all.get(3).findElement(By.tagName("input"));
				 check.click();
			}
		}
		
		

	}

}
