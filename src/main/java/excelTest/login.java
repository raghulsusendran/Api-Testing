package excelTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login {
    
	
	@Test(dataProvider = "getdata" ,dataProviderClass = DataUtits.class)
	public  void alllogin(String data[]) {
		System.err.println("email"+":"+data[0]);
		System.err.println("password"+":"+data[1]);
		
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://letcode.in/signin");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys(data[0]);
		driver.findElement(By.name("password")).sendKeys(data[1],Keys.ENTER);
		driver.quit();
	}

}
