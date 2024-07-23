package SrcCode;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		driver.findElement(By.id("fullName")).sendKeys("Dravid");
		driver.findElement(By.id("join")).sendKeys("I am Bad",Keys.TAB);

		String ele=driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(ele);

		driver.findElement(By.id("clearMe")).clear();

		WebElement editWeb=driver.findElement(By.id("noEdit"));
		Boolean edit= editWeb.isEnabled();
		System.out.println(edit);

		String read=driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println(read);
		driver.navigate().back();

		driver.findElement(By.xpath("//a[contains(text(),'Click')]")).click();
		/*
		 * String cuturl=driver.getCurrentUrl();
		System.out.println("button url"+cuturl);
		driver.findElement(By.id("home")).click();
		String hmurl=driver.getCurrentUrl();
		System.out.println("button url"+hmurl);
		 */

		//driver.navigate().to("");

		WebElement loc=driver.findElement(By.id("position"));
		Point point=loc.getLocation();
		int x=point.getX();
		int y= point.getY();
		System.out.println(x+" "+y);


		WebElement clr=driver.findElement(By.id("color"));
		String btnclr=clr.getCssValue("background-color");
		System.out.println(btnclr);
		Dimension size=clr.getSize();
		System.out.println(size);


		Rectangle rect=driver.findElement(By.id("property")).getRect();
		//Dimension dim=rect.getDimension();
		//System.out.println(dim);

		System.out.println(rect.getWidth());
		System.out.println(rect.getHeight());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[contains(text(),'Drop-Down')]")).click();
		WebElement frut=driver.findElement(By.id("fruits"));
		Select myfrut=new Select(frut);
		myfrut.selectByVisibleText("Mango");

		WebElement hero=driver.findElement(By.id("superheros"));
		Select sphero=new Select(hero);
		Boolean multi=sphero.isMultiple();
		System.out.println(multi);
		sphero.selectByIndex(0);
		sphero.selectByValue("bt");

		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Dialog')]")).click();
		driver.findElement(By.id("accept")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirm")).click();
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.dismiss();

		driver.findElement(By.id("prompt")).click();
		alert.sendKeys("Dravid");
		alert.accept();
		driver.navigate().back();

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.linkText("Inner HTML")).click();
		driver.switchTo().frame("firstFr");
		driver.findElement(By.name("fname")).sendKeys("Rahul");
		driver.findElement(By.name("lname")).sendKeys("Dravid");
		driver.switchTo().frame(0);
		driver.findElement(By.name("email")).sendKeys("rahuldravid@gmail.com");
		driver.navigate().back();

		//handle different buttons
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//a[contains(text(),'Toggle')]")).click();
		driver.findElement(By.id("no")).click();
		WebElement elet=driver.findElement(By.id("one"));
		elet.click();
		boolean sele= elet.isSelected();
		System.out.println(sele);
		Boolean check=driver.findElement(By.id("maybe")).isEnabled();
		System.out.println(check);
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.navigate().back();

		//Drag and drop
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.linkText("AUI - 1")).click();
		//driver.switchTo().frame(1);
		WebElement drag=driver.findElement(By.id("sample-box"));
		Point a=drag.getLocation();
		System.out.println(a.getX()+","+a.getY());
		Actions builder=new Actions(driver);
		//int X=drag.getLocation().getX();
		//int Y=drag.getLocation().getY();
		builder.dragAndDropBy(drag, 200, 300).perform();
		Point b=drag.getLocation();
		System.out.println(b.getX()+","+b.getY());

		driver.navigate().back();
		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.linkText("AUI - 2")).click();
		WebElement srcc=driver.findElement(By.id("draggable"));
		WebElement dest=driver.findElement(By.id("droppable"));
		builder.dragAndDrop(srcc, dest).perform();

		//  driver.findElement(By.xpath("//a[contains(text(),' Get to work')]"))
		/*driver.navigate().back();
		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.linkText("AUI - 4")).click();
		WebElement mutab=driver.findElement(By.xpath("//h3[contains(text(),'Selenium')]"));
		WebElement mutab2=driver.findElement(By.xpath("//h3[contains(text(),'Protractor')]"));
		builder.keyDown(Keys.CONTROL).click(mutab).click(mutab2).perform();
		//builder.moveToElement(mutab).click();
		
		//window handles
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.linkText("Tabs")).click();
		String cwt=driver.getWindowHandle();
		String url1=driver.getCurrentUrl();
		System.out.println(url1);
		Set<String> mulii=driver.getWindowHandles();
		List<String> list= new ArrayList<String>(mulii);
		driver.switchTo().window(list.get(1));
		String url2=driver.getCurrentUrl();
		System.out.println(url2);
		String title1=driver.getTitle();
		System.out.println(title1);
		
		//print all window titles
		driver.findElement(By.id("multi")).click();
		Set<String> multi1=driver.getWindowHandles();
		Iterator<String> it= multi1.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}*/
		
		//just for notes
		/*for (String win : mulii) {
		if(!cwt.contentEquals(win)) {
			driver.switchTo().window(win);
			break;
		}
	   }*/
		
		//findelements
//		driver.navigate().back();
//		js.executeScript("window.scrollBy(0,1000)");
//		driver.findElement(By.linkText("Find Elements")).click();
//		driver.findElement(By.name("username")).sendKeys("john");
//		driver.findElement(By.id("search")).click();
//		List<WebElement> nam=driver.findElements(By.name("john"));
//		System.out.println(nam.size());
		
		
		
		
		
		
		
		
		

		//driver.close();
		//driver.quit();
	}

}
