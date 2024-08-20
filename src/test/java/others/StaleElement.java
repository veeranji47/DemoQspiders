package others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElement {
	
	WebDriver driver;
	@Test
	public void defaultProgressBar() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Others'])")).click();
		driver.findElement(By.xpath("(//section[text()='Stale Element'])")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'stale/input')]")).click();
		WebElement txt = driver.findElement(By.xpath("//input[@placeholder='enter text']"));
		txt.sendKeys("Hello");
		txt.click();
		Thread.sleep(900);
		txt.sendKeys("Welcome");
		
		
	}

}
