package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Yatra {
	
	WebDriver driver;
	Actions actions;
	@Test
	public void defaultDragAndDrop() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement(By.xpath("//table[contains(@class,'days-head day-container-table')]/tbody/tr/descendant::td[contains(@title,'202')]"));
		WebElement date = driver.findElement(By.xpath("//input[@id='BE_flight_origin_date']"));
		date.click();
		String month_yr = "January' 25";
		String currentMonYr = driver.findElement(By.xpath("//div[@class='active-month-holder']")).getText();
		
		
		
	}

}
