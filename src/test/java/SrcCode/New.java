package SrcCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class New {
	@Test
	public void main1() {
		
	WebDriver driver=new ChromeDriver();
    driver.get("https://www.demoblaze.com/index.html");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
    driver.findElement(By.id("loginusername")).sendKeys("RajiniKanth");
	driver.findElement(By.id("loginpassword")).sendKeys("Rajini@123");
	driver.findElement(By.xpath("//button[text()='Log in']")).click();
}
	
	
	
	
	
	

}