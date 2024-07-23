	package makeMyTrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Trip {

	public static void main(String[] args) {
     
		//WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to MakeMyTrip website
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        
        WebElement firstframe = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
        driver.switchTo().frame(firstframe);
       // WebElement close = driver.findElement(By.xpath("//a[@class='close']"));\
        WebElement close = driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']"));
        close.click();
        
       WebElement closes = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
       closes.click();
       
        // Locate origin and destination input fields and enter values
        WebElement originInput = driver.findElement(By.xpath("//input[@id='fromCity']"));
        originInput.sendKeys("Delhi");
        Actions action  = new Actions(driver);
        action.pause(Duration.ofSeconds(2)).sendKeys(originInput, Keys.ARROW_DOWN)
        .sendKeys(Keys.ENTER).perform();

        WebElement destinationInput = driver.findElement(By.xpath("//input[@id='toCity']"));
        destinationInput.sendKeys("Hyderabad");
        action.pause(Duration.ofSeconds(2)).sendKeys(destinationInput, Keys.ARROW_DOWN)
        .sendKeys(Keys.ENTER).perform();
        

        // Select today's date from the calendar for departure
        WebElement departDate = driver.findElement(By.xpath("//div[@aria-label='Wed May 29 2024']"));
        departDate.click();

        // Trigger the search by clicking the search button
        WebElement searchButton = driver.findElement(By.xpath("//a[text()='Search']"));
        searchButton.click();
	}

}
